(ns mastermind.code-breaker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-breaker :refer :all]))

(facts
  "Code Breaker"
  (fact
    "Convert a guess (base 6 number) to base 10 number."
    (guess-to-base10-num [0 0 0 0]) => 0
    (guess-to-base10-num [0 0 0 4]) => 4
    (guess-to-base10-num [0 0 1 0]) => 6
    (guess-to-base10-num [0 0 1 1]) => 7
    (guess-to-base10-num [0 1 1 1]) => 43
    (guess-to-base10-num [1 1 1 1]) => 259
    (guess-to-base10-num [5 5 5 5]) => 1295)

  (fact
    "When number is bigger than 4 digits, return :next-guess-out-of-range."
    (base10-num-to-guess (* 6 6 6 6)) => :guess-out-of-range)

  (fact
    "Convert a base 10 number to a, base 6, 4 digits guess."
    (base10-num-to-guess 0) => [0 0 0 0]
    (base10-num-to-guess 4) => [0 0 0 4]
    (base10-num-to-guess 6) => [0 0 1 0]
    (base10-num-to-guess 7) => [0 0 1 1]
    (base10-num-to-guess 43) => [0 1 1 1]
    (base10-num-to-guess 259) => [1 1 1 1]
    (base10-num-to-guess 1295) => [5 5 5 5])

  (fact
    "Increment guess."
    (inc-guess [0 0 0 0]) => [0 0 0 1]
    (inc-guess [0 0 0 5]) => [0 0 1 0]
    (inc-guess [0 0 5 5]) => [0 1 0 0]
    (inc-guess [0 5 5 5]) => [1 0 0 0])

  (fact
    "Initial guess."
    (break-code nil []) => [0 0 0 0])

  (fact
    "First step for code [1 2 3 4]."
    (break-code [0 0 0 0]
                [[[0 0 0 0] [0 0]]]) => [1 1 1 1])

  (fact
    "First step for code [0 0 0 1]."
    (break-code [0 0 0 0]
                [[[0 0 0 0] [3 0]]]) => [0 0 0 1])

  (fact
    "Second step for code [0 0 1 0]."
    (break-code [0 0 0 1]
                [[[0 0 0 1] [2 2]]]) => [0 0 1 0])

  (fact
    "Two steps are required for [0 0 1 0]."
    (break-code [0 0 0 0]
                [[[0 0 0 0] [3 0]]
                 [[0 0 0 1] [2 2]]]) => [0 0 1 0]))