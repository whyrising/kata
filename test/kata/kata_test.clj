(ns kata.kata-test
  (:require
    [midje.sweet :refer [facts fact =>]]
    [kata.kata :refer :all]))

(fact "nothing"
      true => true)