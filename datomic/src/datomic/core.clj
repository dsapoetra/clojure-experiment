(ns datomic.core)

(def uri "datomic:free://localhost:4334//news")

(def user-schema
  [{:db/doc "User email address"
    :db/ident :user/email
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/unique :db.unique/identity
    :db/id #db/id[:db.part/db]
    :db.install/_attribute :db.part/db}
   {:db/doc "User name"
    :db/ident :user/name
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/index true
    :db/id #db/id[:db.part/db]
    :db.install/_attribute :db.part/db}
   {:db/doc "User roles"
    :db/ident :user/roles
    :db/valueType :db.type/ref
    :db/cardinality :db.cardinality/many
    :db/id #db/id[:db.part/db]
    :db.install/_attribute :db.part/db}
   [:db/add #db/id[:db.part/user] :db/ident :user.roles/guest]
   [:db/add #db/id[:db.part/user] :db/ident :user.roles/author]
   [:db/add #db/id[:db.part/user] :db/ident :user.roles/editor]])

(def group-schema [{:db/doc "Group UUID"
                    :db/ident :group/uuid
                    :db/valueType :db.type/uuid
                    :db/cardinality :db.cardinality/one
                    :db/unique :db.unique/value
                    :db/id #db/id[:db.part/db]
                    :db.install/_attribute :db.part/db}
                   {:db/doc "Group name"
                    :db/ident :group/name
                    :db/valueType :db.type/string
                    :db/cardinality :db.cardinality/one
                    :db/index true
                    :db/id #db/id[:db.part/db]
                    :db.install/_attribute :db.part/db}
                   {:db/doc "Group users"
                    :db/ident :group/users
                    :db/valueType :db.type/ref
                    :db/cardinality :db.cardinality/many
                    :db/id #db/id[:db.part/db]
                    :db.install/_attribute :db.part/db}])


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

