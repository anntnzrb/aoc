(ns aoc22-clj.core
  (:gen-class)
  (:require
   [aoc22-clj.day01 :as d01]
   [aoc22-clj.day02 :as d02]
   [aoc22-clj.day03 :as d03]
   [aoc22-clj.day04 :as d04]
   [aoc22-clj.day05 :as d05]
   [aoc22-clj.day06 :as d06]))

(defn -main
  ([] (.println *err* "Usage: lein run day.part\nEx (Day 3 Part 1): lein run 3.1"))
  ([day]
   (let [day-parts {"1.1" d01/p1
                    "1.2" d01/p2
                    "2.1" d02/p1
                    "2.2" d02/p2
                    "3.1" d03/p1
                    "3.2" d03/p2
                    "4.1" d04/p1
                    "4.2" d04/p2
                    "5.1" d05/p1
                    "5.2" d05/p2
                    "6.1" d06/p1
                    "6.2" d06/p2}]
     (if-let [part (day-parts day)]
       (println (part))
       (.println *err* "Error.")))))
