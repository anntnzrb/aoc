(ns aoc22-clj.day02
  (:require [aoc22-clj.util :as util]
            [clojure.string :as str]))

(def input (util/day-input "02" :sample true))

(def moves {:rock     1
            :paper    2
            :scissors 3})

(def results {:lose 0
              :draw 3
              :win  6})

(defn get-score [move result]
  (+ (moves move) (results result)))

(def scores
  {;; ROCK
   "A X" (get-score :rock :draw)
   "A Y" (get-score :paper :win)
   "A Z" (get-score :scissors :lose)

   ;; PAPER
   "B X" (get-score :rock :lose)
   "B Y" (get-score :paper :draw)
   "B Z" (get-score :scissors :win)

    ;; SCISSORS
   "C X" (get-score :rock :win)
   "C Y" (get-score :paper :lose)
   "C Z" (get-score :scissors :draw)})

(def scores-fixed-result
  {;; ROCK
   "A X" (get-score :scissors :lose)
   "A Y" (get-score :rock :draw)
   "A Z" (get-score :paper :win)

   ;; PAPER
   "B X" (get-score :rock :lose)
   "B Y" (get-score :paper :draw)
   "B Z" (get-score :scissors :win)

   ;; SCISSORS
   "C X" (get-score :paper :lose)
   "C Y" (get-score :scissors :draw)
   "C Z" (get-score :rock :win)})

(defn p1
  "Part 1 solution."
  []
  (->> (str/split input #"\n")
       (map scores)
       (reduce +)))

(defn p2
  "Part 2 solution."
  []
  (->>  (str/split input #"\n")
        (map scores-fixed-result)
        (reduce +)))
