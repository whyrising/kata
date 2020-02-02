(ns mastermind.auto-play-test
  (:require [midje.sweet :refer :all]
            [mastermind.code-maker :as code-maker :refer [score]]
            [mastermind.code-breaker :as code-breaker :refer [break-code]]
            [mastermind.auto-play :refer :all]))

(facts
  "Number of tries to break the code."
  (fact
    "When the initial guess is correct, return 1."
    (auto-play) => 1
    (provided (random-code) => [0 0 0 0],
              (code-maker/score [0 0 0 0] [0 0 0 0]) => [4 0],
              (code-breaker/break-code nil []) => [0 0 0 0]))

  (fact
    "When code is [0 0 0 1], should take 2 tries."
    (auto-play) => 2
    (provided (random-code) => [0 0 0 1])))