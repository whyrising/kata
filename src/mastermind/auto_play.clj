(ns mastermind.auto-play
  (:require [mastermind.code-maker :refer [score]]
            [mastermind.code-breaker :refer [break-code base10-num-to-guess]]))

(defn random-code []
  (base10-num-to-guess (rand-int (dec (* 6 6 6 6)))))

(defn full-score? [score]
  (= score [4 0]))

(defn auto-play []
  (let [master-code (random-code)]
    (loop [tries 1 initial-guess nil game-history []]
      (let [guess (break-code initial-guess game-history)
            score (score master-code guess)]
        (if (full-score? score)
          tries
          (recur (inc tries) guess (conj game-history [guess score])))))))