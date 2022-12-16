(ns aoc22-clj.day01
  (:require [aoc22-clj.util :as util]
            [clojure.string :as str]))

(def input (util/day-input "01" :sample true))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Auxiliary
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn stringv-to-intv
  "Converts a collection COLL of strings to integers."
  [coll]
  (mapv read-string coll))

(defn sum-calories-per-elf
  "Returns a vector with the sums of each elf's calories."
  []
  (->> (str/split input #"\n\n")
       (mapv #(str/split % #"\n"))
       (mapv #(stringv-to-intv %))
       (mapv #(apply + %))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Solutions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn p1
  "Part 1 solution."
  []
  (->> (sum-calories-per-elf)
       (apply max)))

(defn p2
  "Part 2 solution."
  []
  (->> (sum-calories-per-elf)
       (sort-by -)
       (take 3)
       (apply +)))
