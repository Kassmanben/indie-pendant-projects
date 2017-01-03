#lang scheme
(define the-one
  (list
   (list 1 2 3 4 5 4)
   (list 6 7 8 9 10 4)
   (list 1 2 3 4 5 4)
   (list 6 7 8 9 15 4)
   (list 1 1 1 1 1 1)
   )
)

(define (matrix-peeler-2.0  m l)
  (cond
    ((null? m) (reverse l))
    (else (matrix-peeler-2.0 (cdr m) (cons (cdr(car m)) l)))
    )
  )

(define (row-stacker m n l) 
  (cond 
    ((null? m) (cons(reverse n) l))
    (else (row-stacker (cdr m) (cons (car (car m)) n) l))
    )
  )


(define(red-pill m i l)
  (cond
    ((= i 0) (reverse l))
     (else (red-pill  (matrix-peeler-2.0 m (list )) (- i 1) (cons(row-stacker m (list) (list)) l)))    )
  )

(red-pill the-one (length (car(cdr the-one))) (list) )
  
