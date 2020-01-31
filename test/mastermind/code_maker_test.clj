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
  "Scoring Value Matches. Matches that have the right value, but are in the
  wrong position"
  (fact
    "value matches"
    (score [1 2 3 4] [2 0 0 0]) => [0 1]
    (score [1 2 3 4] [2 3 0 0]) => [0 2]
    (score [1 2 3 4] [2 3 1 0]) => [0 3]
    (score [1 2 3 4] [2 3 4 1]) => [0 4]))