(ns mastermind.code-breaker)

(defn guess-to-base10-num [guess]
  (reduce #(+ (* 6 %1) %2) guess))

(defn break-code [past-guesses]
  [0 0 0 0])