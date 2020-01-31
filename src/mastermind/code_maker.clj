(ns mastermind.code-maker)

(defn count-trues [booleans]
  (count (filter identity booleans)))

(defn position-matches [code guess]
  (count-trues (map #(= %1 %2) code guess)))

(defn value-matches [code guess]
  (count-trues (map #(contains? (set code) %1) guess)))

(defn count-of [value values]
  (count (filter #(= value %) values)))

(defn over-count [code guess]
  (let [code-values (set code)]
    (->> code-values
         (map #(- (count-of % guess) (count-of % code)))
         (filter pos?)
         (reduce +))))

(defn score [code guess]
  (let [p-score (position-matches code guess)
        v-matches (value-matches code guess)
        o (over-count code guess)]
    [p-score (- v-matches p-score o)]))