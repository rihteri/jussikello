(ns jussikello.core
  (:gen-class)
  (:require [jussikello.spec :as js]
            [clojure.spec :as s]
            [clojure.test.check.generators :as gen]
            [jussikello.magic :as magic]
            [clojure.string :as str]))

(defn make-sample []
  (gen/sample (s/gen ::js/items) 2500))

(defn read-sample [line]
  (->> (-> line
           (str/split #" "))
       (mapv keyword)))

(defn read-samples [filename]
  (->> (-> filename
           slurp
           (str/split #"\n")
           rest)
       (map read-sample)))

(defn calc-single-subset-result [[subset freqs]]
  (-> freqs keys count))

(defn calc-result-combos [result]
  (->> result
       (map calc-single-subset-result)
       (apply +)))

(defn tunkkaa [n]
  (let [samples (read-samples "training.txt")]
    (calc-result-combos
     (time
      (magic/calc-all-freqs samples n)))))

(defn -main
  [& args]
  (tunkkaa 3))
