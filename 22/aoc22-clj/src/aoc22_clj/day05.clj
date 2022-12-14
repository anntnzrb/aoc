(ns aoc22-clj.day05
  (:require [aoc22-clj.util :as util]
            [clojure.string :as str]))

(def input
  (let [day     "05"
        sample? false]
    (util/day-input (str day (when sample? "-sample")))))

(defn strings-to-ints
  "Converts a collection COLL of strings to integers."
  [coll]
  (map read-string coll))

(def stacks ['()
             '(\Q \F \L \S \R)
             '(\T \P \G \Q \Z \N)
             '(\B \Q \M \S)
             '(\Q \B \C \H \J \Z \G \T)
             '(\S \F \N \B \M \H \P)
             '(\G \V \L \S \N \Q \C \P)
             '(\F \C \W)
             '(\M \P \V \W \Z \G \H \Q)
             '(\R \N \C \L \D \Z \G)])

(def instructions (->> (str/split (get (str/split input #"\n\n") 1) #"\n")
                       (map #(re-seq #"\d+" %))
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

(defn apply-moves'
  [stacks [moves from to]]
  (let [source (drop moves (stacks from))
        target (flatten (conj (stacks to) (take moves (stacks from))))]
    (assoc stacks from source to target)))

(defn p1
  "Part 1 solution."
  []
  (->> (reduce apply-moves stacks instructions)
       (filter not-empty)
       (map peek)
       (apply str)))

(defn p2
  "Part 2 solution."
  []
  (->> (reduce apply-moves' stacks instructions)
       (filter not-empty)
       (map first)
       (apply str)))
