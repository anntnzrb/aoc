(ns aoc22-clj.day03
  (:require
   [aoc22-clj.util :as util]
   [clojure.set    :as set]
   [clojure.string :as str]))

(def input
  (let [day     "03"
        sample? true]
    (util/day-input (str day (when sample? "-sample")))))

(defn split-string-half
  "Splits given string STR in half."
  [^String str]
  (let [str-len     (count str)
        half        (quot str-len 2)
        first-half  (subs str 0 half)
        second-half (subs str half str-len)]
    [first-half second-half]))

(defn str-common-chars
  "Returns a list containing the common characters between STR1 and STR2."
  [^clojure.lang.PersistentList xs]
  (->> xs
       (map #(set %))
       (apply set/intersection)
       (vec)))

(def priorities
  (zipmap "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" (range 1 53)))

(defn p1
  "Part 1 solution."
  []
  (->> (str/split input #"\n")
       (map #(split-string-half %))
       (map #(str-common-chars %))
       (flatten)
       (map #(priorities %))
       (apply +)))

(defn p2
  "Part 2 solution."
  []
  (->> (str/split input #"\n")
       (partition-all 3)
       (map #(str-common-chars %))
       (flatten)
       (map #(priorities %))
       (apply +)))
