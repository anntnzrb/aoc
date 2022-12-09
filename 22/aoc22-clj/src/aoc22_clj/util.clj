(ns aoc22-clj.util
  (:require
   [clojure.java.io :as io]))

(defn day-input
  "Reads file DAY in resources folder."
  [day & sample?]
  (slurp (io/resource (format
                       "day%s.in"
                       (if sample? (str day "-sample") day)))))
