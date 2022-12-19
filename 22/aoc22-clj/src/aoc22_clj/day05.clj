(ns aoc22-clj.day05
  (:require [clojure.test :refer [deftest is testing]]
            [aoc22-clj.util :as util]
            [clojure.string :as str]))

(def input
  (let [sample?               true
        input                 (util/day-input "05" :sample sample?)
        [stacks instructions] (str/split input #"\n\n")
        gen-stacks            (fn [s] (->> (str/split s #"\n")
                                           pop
                                           (apply mapv str)
                                           (map #(re-find #"[A-Z]+" %))
                                           (filter some?)
                                           (map #(apply list %))
                                           (into [()])))
        gen-instructions      (fn [i] (->> (str/split i #"\n")
                                           (map #(re-seq #"\d+" %))
                                           (map util/stringv-to-intv)))]

    {:sample sample?
     :stacks       (gen-stacks stacks)
     :instructions (gen-instructions instructions)}))

(defn apply-moves
  [stacks instructions]
  (let [[moves from to] instructions]
    (loop [source (stacks from)
           target (stacks to)
           moves  moves]
      (if (pos? moves)
        (recur
         (pop source)
         (conj target (peek source))
         (dec moves))
        (assoc stacks from source to target)))))

(defn apply-moves'
  [stacks instructions]
  (let [[moves from to] instructions
        source (drop moves (stacks from))
        target (flatten (conj (stacks to) (take moves (stacks from))))]
    (assoc stacks from source to target)))

(defn p1
  "Part 1 solution."
  []
  (->> (reduce apply-moves (:stacks input) (:instructions input))
       (filter not-empty)
       (map peek)
       (apply str)))

(defn p2
  "Part 2 solution."
  []
  (->> (reduce apply-moves' (:stacks input) (:instructions input))
       (filter not-empty)
       (map first)
       (apply str)))

(deftest p1-test
  (testing "Part 1 Test"
    (if (:sample input)
      (do
        (is (= (p1) "CMZ"))
        (is (= (p2) "MCD")))
      (do
        (is (= (p1) "FZCMJCRHZ"))
        (is (= (p2) "JSDHQMZGF"))))))
