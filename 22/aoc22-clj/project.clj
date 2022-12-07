(defproject aoc22-clj "1.0"
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot aoc22-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
