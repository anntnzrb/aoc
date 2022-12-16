(ns aoc22-clj.day06
  (:require [aoc22-clj.util :as util]
            [clojure.string :as str]))

(def input (util/day-input "06" :sample true))

(defn find-marker
  [str marker-len]
  (loop [str str
         n   marker-len]
    (if (apply distinct? (take marker-len str))
      n
      (recur (drop 1 str) (inc n)))))

(defn p1
  "Part 1 solution."
  []
  (find-marker input 4))

(defn p2
  "Part 2 solution."
  []
  (find-marker input 14))
