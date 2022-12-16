(ns aoc22-clj.day01
  (:require [aoc22-clj.util :as util]
            [clojure.string :as str]))

(def input (util/day-input "01" :sample true))

(defn sum-calories-per-elf
  "Returns a vector with the sums of each elf's calories."
  [input]
  (->> (str/split input #"\n\n")
       (map #(str/split % #"\n"))
       (map #(util/stringv-to-intv %))
       (map #(apply + %))))

(defn p1
  "Part 1 solution."
  []
  (->> (sum-calories-per-elf input)
       (apply max)))

(defn p2
  "Part 2 solution."
  []
  (->> (sum-calories-per-elf input)
       (sort >)
       (take 3)
       (apply +)))
