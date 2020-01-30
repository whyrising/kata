(ns kata.kata)

(defn all-zero? [num1 num2]
  (and (zero? num1) (zero? num2)))

(defn square [x] (* x x))

(defn discriminant [a b c]
  (-
    (square b)
    (* 4 a c)))

(defn real-sol [sign a b disc]
  (/
    (sign (- b) (Math/sqrt disc))
    (* 2 a)))

(defn quad [a b c]
  (cond (all-zero? a b)
    []

    (zero? a)
    [(/ (- b) c)]

    :else
    (let [disc (discriminant a b c)]
      [(real-sol + a b disc)
       (real-sol - a b disc)])))