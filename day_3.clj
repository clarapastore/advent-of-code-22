(ns day-3
  (:require [clojure.string :as str]
            [clojure.set :as set]))

;; I use test-input and test-bag for testing functions before using input data

(def test-input "vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw")

(def test-bag "vJrwpWtwJgWrhcsFMMfFFhFp")

;; alphabet, priority coll and input file

(def alphabet "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

(def priority (map-indexed (fn [i v] (vector (inc i) v)) alphabet))

(def input3 (slurp "resources/input3.txt"))


;; utils

(defn split-half
  "Splits a string in half, returning a vector of splitted strings"
  [s]
  (let [half-point (/ (count s) 2)
        first-half (subs s 0 half-point)
        second-half (subs s half-point)]
    [first-half second-half]))

(defn find-common-char
  "returns char in common between two or three strings. Ex: \N"
  ([str1 str2]
   (let [set1 (set/intersection (set str1) (set str2))]
     (first set1)))
  ([str1 str2 str3]
   (let [set1 (set/intersection (set str1) (set str2) (set str3))]
     (first set1))))

(defn find-priority 
  "Returns the priority number of the corresponding character, based on the priority. Ex: 16"
  [ch]
  (->>
   (filter #(some #{ch} %) priority)
   first
   first))

;; puzzle 1

(defn resolve-puzzle-1 []
  (let [result (->> input3
                    str/split-lines
                    (map #(split-half %))
                    (map #(apply find-common-char %))
                    (map #(find-priority %))
                    (apply +))]
    (str "The answer for puzzle 1 is " result)))

