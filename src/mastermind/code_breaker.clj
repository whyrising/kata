(ns mastermind.code-breaker)

(defn guess-to-base10-num [guess]
  (reduce #(+ (* 6 %1) %2) guess))

(defn- base10-num-to-guess-iter [number n]
  (if (> n 0)
    (filter some?
            (flatten
              [(rem number 6)
               (base10-num-to-guess-iter (quot number 6) (dec n))])))
  )

(defn base10-num-to-guess [number]
  (reverse (base10-num-to-guess-iter number 4)))

(defn break-code [past-guesses]
  [0 0 0 0])