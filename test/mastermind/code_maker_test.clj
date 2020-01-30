(ns mastermind.code-maker-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-maker :refer :all]))

(facts
  "Code Maker"
  (fact
    "score guess with no matches"
    (score [0 0 0 0] [1 1 1 1]) => [])

  (fact
    "score guess with one :pos match"
    (score [0 0 0 0] [0 1 1 1]) => [:pos])
  )