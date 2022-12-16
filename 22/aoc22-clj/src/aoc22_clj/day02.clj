(ns aoc22-clj.day02
  (:require [aoc22-clj.util :as util]
            [clojure.string :as str]))

(def input (util/day-input "02" :sample true))

(def moves {"ROCK"     1
            "PAPER"    2
            "SCISSORS" 3})

(def results {"LOSE" 0
              "DRAW" 3
              "WIN"  6})

(def scores
  {;; ROCK
   "A X" (+ (moves "ROCK")     (results "DRAW"))
   "A Y" (+ (moves "PAPER")    (results "WIN"))
   "A Z" (+ (moves "SCISSORS") (results "LOSE"))

   ;; PAPER
   "B X" (+ (moves "ROCK")     (results "LOSE"))
   "B Y" (+ (moves "PAPER")    (results "DRAW"))
   "B Z" (+ (moves "SCISSORS") (results "WIN"))

    ;; SCISSORS
   "C X" (+ (moves "ROCK")     (results "WIN"))
   "C Y" (+ (moves "PAPER")    (results "LOSE"))
   "C Z" (+ (moves "SCISSORS") (results "DRAW"))})

(def scores-fixed-result
  {;; ROCK
   "A X" (+ (moves "SCISSORS") (results "LOSE"))
   "A Y" (+ (moves "ROCK")     (results "DRAW"))
   "A Z" (+ (moves "PAPER")    (results "WIN"))

   ;; PAPER
   "B X" (+ (moves "ROCK")     (results "LOSE"))
   "B Y" (+ (moves "PAPER")    (results "DRAW"))
   "B Z" (+ (moves "SCISSORS") (results "WIN"))

   ;; SCISSORS
   "C X" (+ (moves "PAPER")    (results "LOSE"))
   "C Y" (+ (moves "SCISSORS") (results "DRAW"))
   "C Z" (+ (moves "ROCK")     (results "WIN"))})

(defn p1
  "Part 1 solution."
  []
  (->> (str/split input #"\n")
       (map #(scores %))
       (apply +)))

(defn p2
  "Part 2 solution."
  []
  (->>  (str/split input #"\n")
        (map #(scores-fixed-result %))
        (apply +)))
