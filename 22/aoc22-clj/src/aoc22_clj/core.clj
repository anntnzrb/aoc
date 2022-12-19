(ns aoc22-clj.core
  (:gen-class)
  (:require
   [aoc22-clj.day01 :as d01]
   [aoc22-clj.day02 :as d02]
   [aoc22-clj.day03 :as d03]
   [aoc22-clj.day04 :as d04]
   [aoc22-clj.day05 :as d05]
   [aoc22-clj.day06 :as d06]))

(def days
  {1 {:desc "Calorie Counting"        :parts [d01/p1 d01/p2]}
   2 {:desc "Rock Paper Scissors"     :parts [d02/p1 d02/p2]}
   3 {:desc "Rucksack Reorganization" :parts [d03/p1 d03/p2]}
   4 {:desc "Camp Cleanup"            :parts [d04/p1 d04/p2]}
   5 {:desc "Supply Stacks"           :parts [d05/p1 d05/p2]}
   6 {:desc "Tuning Trouble"          :parts [d06/p1 d06/p2]}})

(defn -main
  ([] (.println *err* "Usage: lein run day\nEx (Day 3): lein run 3"))
  ([day]
   (let [day     (Integer/valueOf day)
         desc    (get-in days [day :desc])
         parts   (get-in days [day :parts])
         [p1 p2] parts]
     (println (format
               "Selected day: %d
\"%s\"
--------------------------------
Part 1: %s
Part 2: %s " day desc (p1) (p2))))))
