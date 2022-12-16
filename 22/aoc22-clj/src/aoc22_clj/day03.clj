(ns aoc22-clj.day03
  (:require
   [aoc22-clj.util :as util]
   [clojure.set    :as set]
   [clojure.string :as str]))

(def input (util/day-input "03" :sample true))

(defn split-string-half
  "Splits given string STR in half."
  [^String str]
  (split-at (quot (count str) 2) str))

(defn str-common-chars
  "Returns a collection containing the common characters of the elements of COLL."
  [coll]
  (->> coll
       (map set)
       (apply set/intersection)
       (vec)))

(def priorities
  (let [[abc-low abc-up] [(map char (range 97 123)) (map char (range 65 91))]
        abc-full         (concat abc-low abc-up)
        priorities-range (range 1 53)]
    (zipmap abc-full priorities-range)))

(defn p1
  "Part 1 solution."
  []
  (->> (str/split input #"\n")
       (map split-string-half)
       (mapcat str-common-chars)
       (map priorities)
       (apply +)))

(defn p2
  "Part 2 solution."
  []
  (->> (str/split input #"\n")
       (partition-all 3)
       (mapcat str-common-chars)
       (map priorities)
       (apply +)))
