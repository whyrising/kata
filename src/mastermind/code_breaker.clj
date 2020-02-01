(ns mastermind.code-breaker)

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

(defn base10-num-to-guess [number]
  (flatten
    (base10-num-to-guess-iter number [] 4)))

(defn break-code [past-guesses]
  [0 0 0 0])