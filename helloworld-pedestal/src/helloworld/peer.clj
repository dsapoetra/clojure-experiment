(ns helloworld.peer
  (:require [datomic.api :as d :refer (q)]))

(def uri "datomic:dev://localhost:4334/helloworld")

(def schema-tx (read-string (slurp "resources/helloworld/schema.edn")))
(def data-tx (read-string (slurp "resources/helloworld/seed-data.edn")))

(defn init-db []
  (when (d/create-database uri)
    (let [conn (d/connect uri)]
      @(d/transact conn schema-tx)
      @(d/transact conn data-tx))))

(defn results []
  (init-db)
  (let [conn (d/connect uri)]
    (q '[:find ?c :where [?e :hello/color ?c]] (d/db conn))))
