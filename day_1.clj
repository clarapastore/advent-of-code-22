(ns day-1
 (:require [clojure.string :as str]))

;; input is a string called "input-1" (removed for brevity)
;; string looks like this: "5557\n6663\n3952\n4750\n2271\n6653\n4406\n\n4256\n6871\n6720..."

;; goal 1: find the elf which carries the most amount of calories

(->> (str/split input-1 #"\n\n")
       (map #(str/split % #"\n"))
       (map #(map (fn [num] (Integer/parseInt num)) %))
       (map #(reduce + %))
       (apply max))
       
       

;; goal 2: find the total of calories from the top 3 elves

(->> (str/split input-1 #"\n\n")
       (map #(str/split % #"\n"))
       (map #(map (fn [num] (Integer/parseInt num)) %))
       (map #(reduce + %))
       (into [])
       sort
       reverse
       (take 3)
       (reduce +))
