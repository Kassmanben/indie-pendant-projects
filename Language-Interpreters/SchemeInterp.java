import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SchemeInterp {

	static ArrayList<Symbol> symbolTable = new ArrayList<Symbol>();

	/** To save time typing System.out.println 500,000 times **/
	public static void print(String str) {
		StdOut.println(str);
	}

	public static void print(int Int) {
		StdOut.println(Int);
	}

	public static boolean justNum(char[] array) {
		int notNum = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ')') {
				array[i] = ' ';
			}
			if (!Character.isDigit(array[i]) && array[i] != ' ') {
				notNum++;
			}
		}
		if (notNum == 0) {
			return true;
		}
		return false;
	}

	public static boolean isExp(String string) {
		for (Symbol symbol : symbolTable) {
			if (string.contains(symbol.getVar_name())) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNum(String string) {
		int num = 0;
		for (int i = 0; i < 10; i++) {
			if (string.contains(Integer.toString(i))) {
				num++;
			}
		}
		if (num == string.length()) {
			return true;
		}
		return false;
	}

	public static String recurs(String expression) {
		expression = expression.replaceAll("( )+", " ");
		char[] expressionCharArray = expression.toCharArray();
		String[] expressionStrArray = expression.split(" ");
		String newExp = "";
		String oldExp1 = "";
		String oldExp2 = "";
		int parenCount = countParens(expressionCharArray);
		
		if (parenCount == 0 || parenCount == 1) {
			if (justNum(expressionCharArray)) {
				return expression;
			}

			else {
				if (isExp(expression)) {
					for (Symbol symbol : symbolTable) {
						if (expression.contains(symbol.getVar_name())) {
							expression = expression.replace(
									symbol.getVar_name(),
									String.valueOf(symbol.getValue()));
							expressionCharArray = expression.toCharArray();
							expressionStrArray = expression.split(" ");
						}
					}
				}
				for (int i = 0; i < expressionStrArray.length; i++) {
					if (expressionStrArray[i].contains(")")) {
						expressionStrArray[i] = expressionStrArray[i].replace(
								")", "");
					}
					if (expressionStrArray[i].contains("(")) {
						expressionStrArray[i] = expressionStrArray[i].replace(
								"(", "");
					}
				}

				if (expressionStrArray[0].equals("sqrt")) {
					double double1 = Double.parseDouble(expressionStrArray[1]);
					return String.valueOf(Math.sqrt(double1));
				}
				if (expressionStrArray[0].equals("square")) {
					double double1 = Double.parseDouble(expressionStrArray[1]);
					return String.valueOf(double1 * double1);
				}
				if (expressionStrArray[0].equals("sin")) {
					double double1 = Double.parseDouble(expressionStrArray[1]);
					return String.valueOf(Math.sin(double1));
				}
				if (expressionStrArray[0].equals("cos")) {
					double double1 = Double.parseDouble(expressionStrArray[1]);
					return String.valueOf(Math.cos(double1));
				}
				if (expressionStrArray[0].equals("+")) {
					double double1 = Double.parseDouble(expressionStrArray[1]);
					double double2 = Double.parseDouble(expressionStrArray[2]);
					return String.valueOf(double1 + double2);
				}
				if (expressionStrArray[0].equals("-")) {
					double double1 = Double.parseDouble(expressionStrArray[1]);
					double double2 = Double.parseDouble(expressionStrArray[2]);
					return String.valueOf(double1 - double2);
				}
				if (expressionStrArray[0].equals("/")) {
					double double1 = Double.parseDouble(expressionStrArray[1]);
					double double2 = Double.parseDouble(expressionStrArray[2]);
					return String.valueOf(double1 / double2);
				}
				if (expressionStrArray[0].equals("*")) {
					double double1 = Double.parseDouble(expressionStrArray[1]);
					double double2 = Double.parseDouble(expressionStrArray[2]);
					return String.valueOf(double1 * double2);
				}
				if (expressionStrArray[0].equals("define")) {
					double value = Double.parseDouble(expressionStrArray[2]);
					Symbol newSymbol = new Symbol(expressionStrArray[1], value);
					symbolTable.add(newSymbol);
					String thing = "";
					for (int i = 3; i < expressionStrArray.length; i++) {
						thing = thing + expressionStrArray[i] + "\n";
					}
					return recurs(thing);
				} else {
					if (expression.contains(")")) {
						expression = expression.replace(")", "");
					}
					if (expression.contains("(")) {
						expression = expression.replace("(", "");
					}
					expression = expression.trim();
					expressionStrArray = expression.split(" ");
					for (Symbol symbol : symbolTable) {
						if (symbol.getVar_name().equals(expressionStrArray[0])) {
							return String.valueOf(symbol.getValue());
						}
					}
				}
			}
			return expression;
		} else {
			String temp = "";
			int flag = -1;
			for (int i = 0; i < expressionCharArray.length; i++) {
				if (oldExp1.contains("(") && oldExp1.contains(")")) {
					newExp = oldExp1;
					oldExp1 = "";
					oldExp2 = "";
					print(recurs(newExp));
					String thing = arrayToString(expressionCharArray);
					thing = thing.substring(newExp.length());
					thing = thing.trim();
					return recurs(thing);
				}
				if (flag < 2) {
					if (expressionCharArray[i] != ('(')
							&& expressionCharArray[i] != (')')) {
						temp = temp + expressionCharArray[i];
						continue;
					}
					if (expressionCharArray[i] == ('(')) {
						if (flag == -1) {
							flag = 0;
							temp = "";
							continue;
						} else if (flag == 0||flag==1) {
							oldExp1 = oldExp1 + "(" + temp;
							flag = 1;
							temp = "";
							continue;
						}
					}
					if (expressionCharArray[i] == (')')) {
						if (flag == 0) {
							oldExp1 = "(" + temp + ")";
							flag = 1;
							temp = "";
							continue;
						}
						if (flag == 1) {
							newExp = "(" + temp + ")";
							flag = 2;
							temp = "";
							continue;
						}
					}
				}
				temp = temp + expressionCharArray[i];
				if (i == expressionCharArray.length - 1) {
					oldExp2 = temp;
				}
//				 print("Old=" + oldExp1);
//				 print("New=" + newExp);
//				 print("Old=" + oldExp2);

			}
			// print("acc="+acc);
		}
		return recurs(oldExp1 + " " + recurs(newExp) + " " + oldExp2);
	}

	public static int countParens(char[] array) {
		int parens_count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '(') {
				parens_count++;
			}
		}
		return parens_count;
	}

	/** Prints array, ignoring the empty slots **/
	public static void printArray(char[] array) {
		String acc = "";
		for (int i = 0; i < array.length; i++) {
			acc = acc + String.valueOf(array[i]);
			// print(String.valueOf(array[i]));

		}
		StdOut.println(acc);
	}

	public static void printArray(String[] array) {
		String acc = "";
		for (int i = 0; i < array.length; i++) {
			acc = acc + array[i] + " ";
			// print(array[i]);
		}
		StdOut.println(acc);
	}

	/**
	 * Creates a string representing the array, same in appearance to printing
	 * the array
	 **/
	public static String arrayToString(char[] array) {
		String acc = "";
		for (int i = 0; i < array.length; i++) {
			acc = acc + String.valueOf(array[i]);
		}
		return acc;
	}

	// public static String arrayOperations(char[] array) {
	//
	// }

	public static String readItIn() {
		/**
		 * Takes in code line by line, concatenates it and removes any
		 * whitespace or comments
		 **/
		BufferedReader reader = null;
		String scCode = "";
		try {
			String readIn = "";
			reader = new BufferedReader(
					new FileReader(
							"/Users/Ben/Documents/School/CS373/Interpreters/schemeText.txt"));

			while ((readIn = reader.readLine()) != null) {
				if (readIn.contains("%")) {
					readIn = readIn.substring(0, readIn.indexOf("%"));
				}
				if (!readIn.isEmpty()) {
					scCode = scCode + " " + readIn;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		scCode = scCode.trim();
		scCode = scCode.replaceAll("( )+", " ");
		return scCode;
	}

	public static void main(String[] args) {

		/** Input the scheme code by hand **/
		// StdOut.println("Input code");
		// String scCode = StdIn.readLine();
		// scCode = scCode.trim();
		// scCode = scCode.replaceAll("( )+", " ");

		/** Work with a single string at a time **/
		// String scCode =
		// "(*  2  (sin (/   3.1415926535  (/ (sqrt 1600)  (sqrt 100) )  )))";
		// // String scCode= "( + 2 4)";
		// String scCode="(+  5 (sqrt  (+ 4 (sqrt 25))))";
		//
		// scCode = scCode.trim();
		// scCode = scCode.replaceAll("( )+", " ");
		// scCode = scCode.replaceAll("\n", "");
		// // printArray(scCode.split("\\("));
		/** Work with code read from a file **/
		String scCode = readItIn();
		// print(scCode);
		/**
		 * Split up code into an array
		 **/
		char[] codeArray = scCode.toCharArray();
		// print(countParens(codeArray));
		print(recurs(scCode));
		// printArray(codeArray);

	}

}
