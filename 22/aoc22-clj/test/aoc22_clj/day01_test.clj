(ns aoc22-clj.day01-test
  (:require
   [aoc22-clj.day01 :refer [stringv-to-intv]]
   [clojure.test    :refer [deftest is run-tests]]))

(deftest stringv-to-intv-test
  (is (= [7]
         (stringv-to-intv ["7"])))
  (is (= [1 2 3]
         (stringv-to-intv ["1" "2" "3"]))))

(run-tests)
