(ns jussikello.magic-test
  (:require  [clojure.test :as t]
             [clojure.test.check.generators :as gen]
             [jussikello.spec :as js]
             [clojure.spec :as s]
             [jussikello.magic :as magic]))

(t/deftest pick-interesting
  (let [sample [:2 :1 :0 :2 :2 :0 :1 :2 :0 :0 :1 :2 :0 :1 :2 :2 :1 :2 :2 :2 :0 :0 :2 :0 :1 :1]]
    (t/is (= [:0 :2 :1] (magic/pick-interesting sample [2 4 6])))))
