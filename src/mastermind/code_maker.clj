(ns mastermind.code-maker)

(defn count-trues [booleans]
  (count (filter identity booleans)))

(defn position-matches [code guess]
  (count-trues (map #(= %1 %2) code guess)))

(defn value-matches [code guess]
  (count-trues (map #(contains? (set code) %1) guess)))

(defn score [code guess]
  (let [p-score (position-matches code guess)
        v-matches (value-matches code guess)]
    [p-score (- v-matches p-score)]))