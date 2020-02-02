(ns mastermind.code-maker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-maker :refer :all]))

(facts
  "Scoring Position Matches."
  (fact
    "Score guess with no matches."
    (score [0 0 0 0] [1 1 1 1]) => [0 0])

  (fact
    "Score guess with one :pos match."
    (score [0 0 0 0] [0 1 1 1]) => [1 0])

  (fact
    "Score guess with two :pos match."
    (score [0 0 0 0] [0 1 1 0]) => [2 0])

  (fact
    "Score guess with many position matches."
    (score [0 0 0 0] [0 1 0 0]) => [3 0]
    (score [0 0 0 0] [1 0 0 0]) => [3 0]
    (score [0 0 0 0] [0 0 0 0]) => [4 0]))

(facts
  "Scoring Value Matches. Matches that have the right value, but are in the
  wrong position."
  (fact
    "Value matches."
    (score [1 2 3 4] [2 0 0 0]) => [0 1]
    (score [1 2 3 4] [2 3 0 0]) => [0 2]
    (score [1 2 3 4] [2 3 1 0]) => [0 3]
    (score [1 2 3 4] [2 3 4 1]) => [0 4]))

(fact
  "Guesses with some position and some value matches."
  (score [1 2 3 4] [1 2 4 3]) => [2 2])

(fact
  "When there are duplicate colors in the guess, they cannot all be
  awarded/scored unless they correspond to the same number of duplicates colors
  in the hidden code."
  (score [1 2 3 4] [3 3 3 4]) => [2 0]
  (score [1 1 3 4] [1 3 1 3]) => [1 2]
  (score [3 3 3 3] [3 1 1 1]) => [1 0])