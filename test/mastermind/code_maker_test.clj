(ns mastermind.code-maker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-maker :refer :all]))

(facts
  "Scoring Position Matches"
  (fact
    "score guess with no matches"
    (score [0 0 0 0] [1 1 1 1]) => [0 0])

  (fact
    "score guess with one :pos match"
    (score [0 0 0 0] [0 1 1 1]) => [1 0])

  (fact
    "score guess with two :pos match"
    (score [0 0 0 0] [0 1 1 0]) => [2 0])

  (fact
    "score guess with many position matches"
    (score [0 0 0 0] [0 1 0 0]) => [3 0]
    (score [0 0 0 0] [1 0 0 0]) => [3 0]
    (score [0 0 0 0] [0 0 0 0]) => [4 0]))

(facts
  "Scoring Value Matches"
  (fact
    "score guess with one value match and no pos match"
    (score [1 2 3 4] [2 0 0 0]) => [0 1]))