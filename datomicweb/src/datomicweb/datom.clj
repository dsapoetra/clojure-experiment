(ns datomicweb.datom
   (require [datomic.api :as d :refer [q db]]
            [datomicweb.system :as system]
            [com.stuartsierra.component :as component]))

(def uri "datomic:dev://localhost:4334/datomicweb")


#_(defn incr
  []
  (dosync
   (alter counter inc @counter)))

(defn connect-to-database
  [uri]
  (d/connect uri))

(defrecord Database [uri connection]
  ;; Implement the Lifecycle protocol
  component/Lifecycle
  (start [component]
    (println ";; Starting database")
    (let [conn (connect-to-database uri)]
      (assoc component :connection conn)))
  (stop [component]
    (println ";; Stopping database")
    (.close connection)
    (assoc component :connection nil)))

(defn new-database [uri]
  (map->Database {:uri uri}))


(defn create-db
  []
  (d/create-database uri))

(defn dba
  []
  (d/db (d/connect uri)))

(defn schema
  []
  (read-string (slurp "/Users/dimassaputra/Code/experiment/datomicweb/resources/docs/schema.edn")))

(defn upload-schema
  [schema]
  (d/transact (d/connect uri) schema))

(defn tx-data
  [email name address age]
  [{:db/id (d/tempid :db.part/user)
                   :user/email email
                   :user/name name
                   :user/address address
                   :user/age age}])

(defn add-data
  [database email name address age]
  @(d/transact (d/connect uri) (tx-data email name address age)))

(defn search-age
  [name]
  (->> (q '[:find ?age
        :in $ ?name
        :where
        [?p :user/name ?name]
        [?p :user/age ?age]]
      (db (d/connect uri)) name)
       (first)
    (first)
    (hash-map :usia)))


(defn search-address
  [name]
  (->> (q '[:find ?address
        :in $ ?name
        :where
        [?p :user/name ?name]
        [?p :user/address ?address]]
      (db (d/connect uri)) name)
       (first)
      (first)
      (hash-map :alamat)))

(defn search-email
  [name]
 (->>
  (q '[:find ?email
          :in $ ?name
          :where
          [?p :user/name ?name]
          [?p :user/email ?email]]
        (db (d/connect uri)) name)
    (first)
    (first)
    (hash-map :email)))

(defn wrap-and-map-by-name
  [name]
  (conj {:nama name} (search-email "dimas") (search-address "dimas") (search-age "dimas")))


(defn search-age-by-email
  [email]
  (->> (q '[:find ?age
        :in $ ?email
        :where
        [?p :user/email ?email]
        [?p :user/age ?age]]
      (db (d/connect uri)) email)
       (first)
    (first)
    (hash-map :usia)))


(defn search-address-by-email
  [email]
  (->> (q '[:find ?address
        :in $ ?email
        :where
        [?p :user/email ?email]
        [?p :user/address ?address]]
      (db (d/connect uri)) email)
       (first)
      (first)
      (hash-map :alamat)))

(defn search-name-by-email
  [email]
 (->>
  (q '[:find ?name
          :in $ ?email
          :where
          [?p :user/email ?email]
          [?p :user/name ?name]]
        (db (d/connect uri)) email)
    (first)
    (first)
    (hash-map :nama)))

(defn wrap-and-map-by-email
  [email]
  (conj  (search-name-by-email email) {:email email} (search-address-by-email email) (search-age-by-email email)))

(defn eliminate
  [input]
  (let [by-email (wrap-and-map-by-email input)
        by-name (wrap-and-map-by-name input)]
    (if (some nil? (vals by-email))
      by-name
      by-email)))
