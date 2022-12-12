(ns aoc22-clj.day04
  (:require [aoc22-clj.util :as util]
            [clojure.string :as str]
            [clojure.set :as set]))

(def input
  (let [day     "04"
        sample? true]
    (util/day-input (str day (when sample? "-sample")))))

(defn gen-range
  "Generates a collection given a range from STR."
  [^String str]
  (let [split (str/split str #"-")
        x     (read-string (get split 0))
        y     (read-string (get split 1))]
    (range x (+ y 1))))

(defn gen-range2
  "Wrapper around gen-range, given collection COLL."
  [coll]
  (->> coll
       (map #(gen-range %))
       (map #(set %))))

(defn bidirectional-subset?
  "Check if S1 is subset of S2 and viceversa."
  [s1 s2]
  (or
   (set/subset? s1 s2)
   (set/subset? s2 s1)))

(defn common
  []
  (->> (str/split input #"\n")
       (map #(str/split % #","))
       (map #(gen-range2 %))))

(defn p1
  "Part 1 solution."
  []
  (->> (common)
       (map #(bidirectional-subset? (first %) (second %)))
       (filter true?)
       (count)))

(defn p2
  "Part 2 solution."
  []
  (->> (common)
       (map #(set/intersection (first %) (second %)))
       (filter not-empty)
       (count)))
