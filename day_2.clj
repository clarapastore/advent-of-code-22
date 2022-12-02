(ns day-2
  (:require [clojure.string :as str]))

(def input2 "resources/input2.txt")

(def rounds
  (->> input2
       slurp
       str/split-lines))

(def play-round-1
  (fn [round]
    (case round
      "A X" (+ 1 3)
      "B X" (+ 1 0)
      "C X" (+ 1 6)
      "A Y" (+ 2 6)
      "B Y" (+ 2 3)
      "C Y" (+ 2 0)
      "A Z" (+ 3 0)
      "B Z" (+ 3 6)
      "C Z" (+ 3 3)
      nil)))

(def play-round-2
  (fn [round]
    (case round
      "A X" (+ 0 3)
      "B X" (+ 0 1)
      "C X" (+ 0 2)
      "A Y" (+ 3 1)
      "B Y" (+ 3 2)
      "C Y" (+ 3 3)
      "A Z" (+ 6 2)
      "B Z" (+ 6 3)
      "C Z" (+ 6 1)
      nil)))


(comment
  (->> rounds
       (map play-round-1)
       (remove nil?)
       (apply +))
  (->> rounds
       (map play-round-2)
       (remove nil?)
       (apply +)))
