(ns aoc22-clj.day05
  (:require [aoc22-clj.util :as util]
            [clojure.string :as str]))

(def input
  (let [day     "05"
        sample? true]
    (util/day-input (str day (when sample? "-sample")))))

(defn strings-to-ints
  "Converts a collection COLL of strings to integers."
  [coll]
  (map read-string coll))

(def stacks ['() '(\N \Z) '(\D \C \M) '(\P)])

(def instructions (->> (str/split (get (str/split input #"\n\n") 1) #"\n")
                       (map #(re-seq #"\d" %))
                       (map strings-to-ints)))

(defn apply-moves
  [stacks [moves from to]]
  (loop [source (stacks from)
         target (stacks to)
         moves  moves]
    (if (pos? moves)
      (recur
       (pop source)
       (conj target (peek source))
       (dec moves))
      (assoc stacks from source to target))))

(defn p1
  "Part 1 solution."
  []
  (->> (reduce apply-moves stacks instructions)
       (filter not-empty)
       (map peek)
       (apply str)))

(defn p2
  "Part 2 solution."
  [])
