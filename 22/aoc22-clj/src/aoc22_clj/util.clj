(ns aoc22-clj.util
  (:require
   [clojure.java.io :refer [resource]]))

(defn day-input
  "Reads file DAY in resources folder."
  [day & {:keys [sample]}]
  (let [suffix (if sample "-sample" "")]
    (slurp (resource (str "day" day suffix ".in")))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Auxiliary
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn stringv-to-intv
  "Converts a collection COLL of strings to integers."
  [coll]
  (mapv #(Integer/valueOf %) coll))
