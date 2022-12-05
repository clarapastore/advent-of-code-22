(ns day-4.core
  (:require [clojure.string :as str]))

(def test-input "2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8")

(def input (slurp "resources/input4.txt"))

(defn str->int [string]
  (let [[a b] (clojure.string/split string #"-")
        a (Integer/parseInt a)
        b (Integer/parseInt b)]
    [a b]))

(defn contained-in-range? [range1 range2]
  (let [pred1 (every-pred #(<= % (second range2)) #(>= % (first range2)))
        pred2 (every-pred #(<= % (second range1)) #(>= % (first range1)))]
    (or (every? pred1 range1) (every? pred2 range2))))

(defn partially-contained-in-range? [range1 range2]
  (let [pred1 (every-pred #(<= % (second range2)) #(>= % (first range2)))
        pred2 (every-pred #(<= % (second range1)) #(>= % (first range1)))]
    (or (some pred1 range1) (some pred2 range2))))



(defn solve-puzzle-1 []
  (let [result (->> input
                    str/split-lines
                    (map #(str/split % #","))
                    (map (fn [pair] (into [] (map #(into [] (str->int %)) pair))))
                    (map #(apply contained-in-range? %))
                    (remove false?)
                    count)]
        (str "The solution to puzzle 1 is: " result)))
  

(defn solve-puzzle-2 []
   (let [result (->> input
                     str/split-lines
                     (map #(str/split % #","))
                     (map (fn [pair] (into [] (map #(into [] (str->int %)) pair))))
                     (map #(apply partially-contained-in-range? %))
                     (remove nil?)
                     count)]
        (str "The solution to puzzle 2 is: " result)))

