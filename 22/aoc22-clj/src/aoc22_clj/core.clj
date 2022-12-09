(ns aoc22-clj.core
  (:gen-class)
  (:require
   [aoc22-clj.day01 :as d01]
   [aoc22-clj.day02 :as d02]
   [aoc22-clj.day03 :as d03]))

(defn -main
  ([] (.println *err* "Usage: lein run day.part\nEx (Day 3 Part 1): lein run 3.1"))
  ([day]
   (case day
     "1.1" (println (d01/p1))
     "1.2" (println (d01/p2))
     "2.1" (println (d02/p1))
     "2.2" (println (d02/p2))
     "3.1" (println (d03/p1))
     "3.2" (println (d03/p2))
     (.println *err* "Error."))))
