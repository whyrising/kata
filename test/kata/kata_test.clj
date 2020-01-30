(ns kata.kata-test
  (:require
    [midje.sweet :refer [facts fact =>]]
    [kata.kata :refer :all]))

(facts "quadratic formula tests"
       (fact "degenerate"
             (quad 0 0 1) => [])

       (fact "linear"
             (quad 0 1 1) => [-1])

       (fact "simple"
             (quad 1 0 -1) => [1.0 -1.0]))