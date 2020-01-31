(ns mastermind.code-breaker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-breaker :refer :all]))

(facts
  "Code Breaker"
  (fact
    "convert a guess (base 6 number) to base 10 number"
    (guess-to-base10-num [0 0 0 0]) => 0
    (guess-to-base10-num [0 0 0 4]) => 4
    (guess-to-base10-num [0 0 1 0]) => 6
    (guess-to-base10-num [0 0 1 1]) => 7
    (guess-to-base10-num [0 1 1 1]) => 43
    (guess-to-base10-num [1 1 1 1]) => 259
    (guess-to-base10-num [5 5 5 5]) => 1295)

  (fact
    "initial guess"
    (break-code []) => [0 0 0 0]))
