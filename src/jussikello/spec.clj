(ns jussikello.spec
  (:require [clojure.spec :as s]
            [clojure.test.check.generators :as gen]))

(defn one-keyword-spec [kw]
  (s/with-gen
    #(= % kw)
    #(gen/return kw)))

(s/def ::item (s/or :0 (one-keyword-spec :0)
                    :1 (one-keyword-spec :1)
                    :2 (one-keyword-spec :2)))

(s/def ::items (s/coll-of ::item :count 26))
