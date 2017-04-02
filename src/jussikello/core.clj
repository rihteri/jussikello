(ns jussikello.core
  (:gen-class)
  (:require [jussikello.spec :as js]
            [clojure.spec :as s]
            [clojure.test.check.generators :as gen]
            [jussikello.magic :as magic]))

(defn make-sample []
  (gen/sample (s/gen ::js/items) 2500))

(defn tunkkaa [n]
  (let [samples (make-sample)]
    (time
     (magic/calc-all-freqs samples n))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (tunkkaa))
