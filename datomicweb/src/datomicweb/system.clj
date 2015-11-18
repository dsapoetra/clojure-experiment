(ns datomicweb.system
  (:require [com.stuartsierra.component :as component]
            [datomic.api :as d :refer [q db]]))

(def uri "datomic:dev://localhost:4334/datomicweb")


(defn execute-query
  [conn query input]
  (println 2))

(defn get-user [database username]
  (:connection database))
