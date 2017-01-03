import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PostscriptCompiler {

	/** To save time typing System.out.println 500,000 times **/
	public static void print(String str) {
		StdOut.println(str);
	}

	public static void print(int Int) {
		StdOut.println(Int);
	}

	/** Prints array, ignoring the empty slots **/
	public static void printArray(String[] array) {
		String acc = "";
		for (int i = 0; i < array.length; i++) {
			if (!array[i].equals("Empty")) {
				acc = acc + array[i] + " ";
			}
		}
		StdOut.println(acc);
	}

	/**
	 * Creates a string representing the array, same in appearance to printing
	 * the array
	 **/
	public static String arrayToString(String[] array) {
		String acc = "";
		for (int i = 0; i < array.length; i++) {
			if (!array[i].equals("Empty")) {
				acc = acc + array[i] + " ";
			}
		}
		return acc;
	}

	/** Duplicates the value its called upon to **/
	public static String dup(String[] array) {
		String acc = "";
		for (int i = 0; i < array.length; i++) {
			if (!array[i].equals("Empty")) {
				acc = acc + array[i] + " ";
			} else if (array[i].equals("Empty") && i > 0) {
				acc = acc + array[i - 1] + " ";
			}
		}
		return acc;
	}

	/** Switches two values in the stack **/
	public static void exch(String[] array, int argNum) {
		String temp = array[argNum - 1];
		array[argNum - 1] = array[argNum - 2];
		array[argNum - 2] = temp;
	}

	/**
	 * Returns the value at a specific index, index beginning at 0 at the top of
	 * the stack (or wherever index is)
	 **/
	public static String index(String[] array, int val, int argNum) {
		if ((argNum - val - 2) > -1) {
			array[argNum - 1] = "Empty";
			return array[argNum - val - 2];
		}
		return ("You passed " + (argNum - val - 2) + " as an index argument \n" + "This in an invalid argument");
	}

	/**
	 * Copies a given number of values and adds them to the top of the stack (or
	 * wherever copy is)
	 **/

	public static String copy(String[] array, int numberOfThings, int argNum) {
		String acc = "";
		if (argNum - numberOfThings - 2 < -1) {
			return ("You passed" + (argNum - numberOfThings - 2)
					+ " as copy argument \n" + "This in an invalid argument");
		}
		if (numberOfThings == 1) {
			dup(array);
		}
		for (int i = argNum - 2; i > argNum - numberOfThings - 2; i--) {
			acc = array[i] + " " + acc;
		}
		array[argNum - 1] = acc;
		String clearThoseNulls = arrayToString(array);
		clearThoseNulls = clearThoseNulls.trim();
		clearThoseNulls = clearThoseNulls.replaceAll("( )+", " ");
		return clearThoseNulls;
	}

	/** Rolls a certain number of stack elements back **/

	public static String roll(String[] array, int numberOfThings,
			int whereToRoll, int argNum) {
		String acc = "";

		/**
		 * Rolling a negative "number of things" (i.e. elements from the bottom
		 * of the stack) is the same as rolling everything else normally
		 **/
		if (numberOfThings < 0) {
			numberOfThings = whereToRoll + numberOfThings;
		}

		/**
		 * If you are rolling more things than there is room to roll, nothing
		 * will happen i.e. 2 5 roll will not work because you are trying to
		 * roll 5 elements back 2 places
		 **/
		if (numberOfThings - whereToRoll > 1
				|| numberOfThings - whereToRoll == 0) {
			String accu = "";
			for (int i = 0; i < array.length; i++) {
				accu = accu + array[i] + " ";
			}
			return accu;
		}
		/**
		 * Creates a string of the elements being rolled
		 **/
		if (numberOfThings - whereToRoll < 0) {
			for (int i = argNum - 3, j = 0; j < numberOfThings; i--) {
				acc = array[i] + " " + acc;
				array[i] = "Empty";
				j++;
			}
		}

		/**
		 * Weird special case where if the number of things being rolled is only
		 * one more than the spaces to roll, it'll only roll the top element
		 * back
		 * **/
		if (numberOfThings - whereToRoll == 1) {
			acc = array[argNum - 3];
			array[argNum - 3] = "Empty";
			numberOfThings = 1;
		}

		/**
		 * Finds the number of places back it needs to roll Adds all the
		 * elements up to that point to a string Puts the rolled elements in
		 * Finishes the rest of the string
		 **/
		String rollString = "";
		int thisManyTimes = argNum - 2 - whereToRoll;

		for (int i = 0; i < thisManyTimes; i++) {
			rollString = rollString + " " + array[i];
		}
		rollString = rollString + " " + acc;
		for (int i = thisManyTimes; i < array.length; i++) {
			if (!array[i].equals("Empty")) {
				rollString = rollString + " " + array[i];
			}
		}
		rollString = rollString.trim();
		rollString = rollString.replaceAll("( )+", " ");
		return rollString;
	}

	/** Pops the top element off the stack **/
	public static String pop(String[] array, int argNum) {
		array[argNum - 1] = "Empty";
		array[argNum] = "Empty";
		deleteThoseNulls(array);
		String clearThoseNulls = arrayToString(array);
		clearThoseNulls = clearThoseNulls.trim();
		clearThoseNulls = clearThoseNulls.replaceAll("( )+", " ");
		return clearThoseNulls;
	}

	public static String arrayOperations(String[] array) {
		int distanceToOp = 0;

		for (int i = 0; i < array.length; i++) {
			/**
			 * Creates an initial distance. If this does not change by the end
			 * of the loop, we have reached an operation!
			 **/
			int dist0 = distanceToOp;

			for (int j = 0; j < 10; j++) {

				/**
				 * Tests if the array element contains a number, i.e. it is a
				 * float,integer, or double
				 **/
				String num = Integer.toString(j);

				if (array[i].contains(num)) {
					distanceToOp++;
					break; // As to not count elements with multiple digits as
							// multiple elements
				}
			}
			if (distanceToOp == dist0) {
				return Integer.toString(distanceToOp);
			}
		}
		/** Accounts for instances with only numbers, no operations **/
		if (distanceToOp == array.length) {
			return "OnlyNum";
		}
		return Integer.toString(distanceToOp);
	}

	public static double oneArgumentOps(String op, double val) {
		double result = 0;
		/** Tests all of the single argument mathematical operations **/
		if (op.equals("sin")) {
			val = Math.toRadians(val);
			result = Math.sin(val);
			result = Math.floor(result * 100000000) / 100000000;
		}

		else if (op.equals("cos")) {
			val = Math.toRadians(val);
			result = Math.cos(val);
			/**
			 * Rounds results to 8 decimal places (weird thing with cos(90)
			 * being some very small number because computers cannot approximate
			 * Pi
			 **/
			result = Math.floor(result * 100000000) / 100000000;
		}

		else if (op.equals("sqrt")) {
			if (val >= 0) {
				result = Math.sqrt(val);
			}
			/** Rounds results to 8 decimal places **/
			result = Math.floor(result * 100000000) / 100000000;
		}

		else {
			/** Clarifies what it has been passed that does not work **/
			StdOut.println(op + "is not a valid operation on " + val);
		}
		return result;
	}

	public static double twoArgumentOps(String op, double val1, double val2) {

		double result = 0;
		/** Tests all of the double argument mathematical operations **/
		if (op.equals("add")) {
			result = val1 + val2;
		}

		else if (op.equals("sub")) {
			result = val1 - val2;
		}

		else if (op.equals("mul")) {
			result = val1 * val2;
		}

		else if (op.equals("div")) {
			if (val2 != 0) {
				result = val1 / val2;
			}
		}

		else if (op.equals("idiv")) {
			if (val2 != 0) {
				result = Math.floor(val1 / val2);
			}
		}

		else if (op.equals("mod")) {
			result = val1 % val2;
		}

		else {
			StdOut.println(op + " is not a valid operation");
		}
		return result;
	}

	/**
	 * Essentially shuffles the array down to its minimum size, filling in all
	 * of the "null" array elements. (i.e. elements that have been consumed by
	 * operations)
	 **/
	public static void deleteThoseNulls(String[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("Empty") && i < (array.length - 1)) {
				for (int j = i; j < (array.length - 1); j++) {
					array[j] = array[j + 1];
				}
				array[array.length - 1] = "Empty";
			}
		}
	}

	public static String readItIn() {
		/**
		 * Takes in code line by line, concatenates it and removes any
		 * whitespace or comments
		 **/
		BufferedReader reader = null;
		String psCode = "";
		try {
			String readIn = "";
			reader = new BufferedReader(
					new FileReader(
							"/Users/Ben/Documents/School/CS373/project_test_quadratic"));

			while ((readIn = reader.readLine()) != null) {
				if (readIn.contains("%")) {
					readIn = readIn.substring(0, readIn.indexOf("%"));
				}
				if (!readIn.isEmpty()) {
					psCode = psCode + " " + readIn;
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
		psCode = psCode.trim();
		psCode = psCode.replaceAll("( )+", " ");
		return psCode;
	}

	public static void main(String[] args) {

		/** Input the postscript code by hand **/
		// StdOut.println("Input code");
		// String psCode = StdIn.readLine();
		// psCode = psCode.trim();
		// psCode = psCode.replaceAll("( )+", " ");

		/** Work with a single string at a time **/
		// String psCode = "6 -1 -2 -1 dup pstack";
		// psCode = psCode.trim();
		// psCode = psCode.replaceAll("( )+", " ");

		/** Work with postscript code read from a file **/
		String psCode = readItIn();

		/**
		 * Split up code into an array
		 **/
		String[] codeArray = psCode.split(" ");
		printArray(codeArray);

		while (true) {
			String argumentsForOp = arrayOperations(codeArray);
			if (argumentsForOp.equals("0")) {
				String op = codeArray[0];
				if (codeArray[0].equals("pstack")) {
					break;
				} else if (op.equals("pop")) {
					StdOut.println(op + " needs more arguments");
					break;
				} else {
					break;
				}
			}

			if (!argumentsForOp.equals("OnlyNum")
					&& !argumentsForOp.equals("0")) {
				int argNum = Integer.parseInt(argumentsForOp);

				String op = codeArray[argNum];
				codeArray[argNum] = "Empty";

				double val2 = Double.parseDouble(codeArray[argNum - 1]);
				if (op.equals("sin") || op.equals("cos") || op.equals("sqrt")) {
					codeArray[argNum - 1] = String.valueOf(oneArgumentOps(op,
							val2));
				} else if (op.equals("dup")) {
					codeArray = dup(codeArray).split(" ");
				} else if (op.equals("exch")) {
					exch(codeArray, argNum);
				} else if (op.equals("pop")) {
					codeArray = pop(codeArray, argNum).split(" ");
				} else if (op.equals("pstack")) {
					printArray(codeArray);
				} else if (op.equals("index")) {
					int val = Integer.parseInt(codeArray[argNum - 1]);
					codeArray[argNum] = index(codeArray, val, argNum);
				} else if (op.equals("copy")) {
					int numberOfThings = Integer
							.parseInt(codeArray[argNum - 1]);
					codeArray = copy(codeArray, numberOfThings, argNum).split(
							" ");
				} else if (op.equals("roll")) {
					int numberOfThings = Integer
							.parseInt(codeArray[argNum - 1]);
					codeArray[argNum - 1] = "Empty";
					int whereToRoll = Integer.parseInt(codeArray[argNum - 2]);
					codeArray[argNum - 2] = "Empty";
					codeArray = roll(codeArray, numberOfThings, whereToRoll,
							argNum).split(" ");
				} else if (op.equals("add") || op.equals("sub")
						|| op.equals("mul") || op.equals("div")
						|| op.equals("idiv") || op.equals("mod")) {
					double val1 = Double.parseDouble(codeArray[argNum - 2]);
					codeArray[argNum - 1] = "Empty";
					codeArray[argNum - 2] = String.valueOf(twoArgumentOps(op,
							val1, val2));
				}
			}

			if (argumentsForOp.equals("OnlyNum")) {
				StdOut.println("Done!");
				break;
			}

			deleteThoseNulls(codeArray);

			/**
			 * Cleans up array, creates new one of correct size, deletes any
			 * extra whitespace
			 **/
			String clearThoseNulls = arrayToString(codeArray);
			clearThoseNulls = clearThoseNulls.trim();
			clearThoseNulls = clearThoseNulls.replaceAll("( )+", " ");
			codeArray = clearThoseNulls.split(" ");

			 printArray(codeArray);

		}

	}
}
