(ns mastermind.code-breaker
  (:require [mastermind.code-maker :as code-maker :refer [score]]))

(defn guess-to-base10-num [guess]
  (reduce #(+ (* 6 %1) %2) guess))

(defn- base10-num-to-guess-iter [dividend guess digits]
  (let [base6-divisor 6]
    (if (= digits 0)
      guess
      (recur
        (quot dividend base6-divisor)
        [(rem dividend base6-divisor) guess]
        (dec digits)))))

(defn throw-big-number-exception [number]
  (throw
    (RuntimeException.
      (str "The given number '" number "' is bigger than 1295"))))

(defn base10-num-to-guess [number]
  (if (= number (* 6 6 6 6))
    :guess-out-of-range

    (flatten
      (base10-num-to-guess-iter number [] 4))))

(defn inc-guess [guess]
  (->> guess
       guess-to-base10-num
       inc
       base10-num-to-guess))

(defn and-booleans [bool-list]
  (every? identity bool-list))

(defn master-code? [code game-history]
  (and-booleans
    (for [guess-score game-history]
      (let [guess (first guess-score) score (second guess-score)]
        (= (code-maker/score code guess)
           score)))))

(defn next-guess [starting-guess game-history]
  (loop [code starting-guess]
    (if (master-code? code game-history)
      code
      (recur (inc-guess code)))))

(defn break-code [starting-guess game-history]
  (if (nil? starting-guess)
    [0 0 0 0]
    (next-guess starting-guess game-history)))