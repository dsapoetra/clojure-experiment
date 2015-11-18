(ns cloweb.datomic
  (:require
    [com.stuartsierra.component :as component]
    [datomic.api :as d]))

(declare init-db)

(defrecord Database [db-uri part mode]
  component/Lifecycle
  (start [this]
   (println "start"))
  (stop [this]
    this))

(defn make
  "The constructor function for creating a datomic component, it requires db-uri,
  and mode. Once started, it will have :db and :connection. Use :connection for
  datomic connection and :db is a function that returns the db value."
  [db-uri part mode]
  {:pre [(string? db-uri) (some #{mode} #{:test :dev :prod})]}
  (println "Creating Datomic component")
  (map->Database {:db-uri db-uri
                  :part   part
                  :mode   mode}))

(defn- init-db
  [conn part]
  (println "lala"))

(defrecord Lis [lis]
    IFoo
  (took [i] (println "took"))
  (dropped [i] (println "drop")))
