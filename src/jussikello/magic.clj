(ns jussikello.magic
  (:require [clojure.math.combinatorics :as combo]))

(defn pick-interesting [items sample]
  (mapv (partial get sample) items))

(defn calc-freqs [samples items]
  (->> samples
       (mapv (partial pick-interesting items))
       frequencies))

(defn get-item-configs [n]
  (->> n
       (combo/combinations (range 26))
       (map vec)))

(defn calc-all-freqs [samples n]
  (let [itemses (get-item-configs n)]
    (->> itemses
         (pmap (partial calc-freqs samples))
         (interleave itemses)
         (apply hash-map))))
