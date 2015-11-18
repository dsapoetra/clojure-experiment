(ns automata1.coba
  (:require [automat.viz :as viz]
           [automat.core :as a]))

(defn two-possibility [coll coll1 coll2]
  (viz/view (a/or coll1 coll coll2)))

(defn no-two-1 [initiate-coll max-length]
  (if (< (count initiate-coll) max-length)
    (if (= (last (initiate-coll) 1))
      (into initiate-coll [0]))))

#_(defn generate-zero [start-coll max-length]
  (if (< (count start-coll) max-length)
    (if (= (first start-coll) 0)
       (merge '() start-coll (recur (vector (cons 1 start-coll)) max-length))
       (merge '() start-coll (recur  (vector (cons 0 start-coll)) max-length)))
    (merge '() start-coll)))
