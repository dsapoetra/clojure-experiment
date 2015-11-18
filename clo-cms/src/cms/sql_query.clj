(ns cms.sql_query
  (:require [clojure.java.jdbc :as j]
            [cms.sql_config :as config]
            [clj-time.local :as l]
            [clj-time.coerce :as c]
            [noir.util.crypt :as crypt]))

(defn list-of-id-post []
  (let [id (j/query config/cms ["SELECT idpost FROM post"])]
    (if (empty? (j/query config/cms ["SELECT idpost FROM post"]))
      '(0)
      (map #(get % :idpost) (j/query config/cms ["SELECT idpost FROM post"])))))

(defn list-of-category []
  (let [id (j/query config/cms ["SELECT nama FROM category"])]
    (if (empty? (j/query config/cms ["SELECT nama FROM category"]))
      '("")
      (map #(get % :nama) (j/query config/cms ["SELECT nama FROM category"])))))

(defn list-of-writer []
  (let [id (j/query config/cms ["SELECT nama FROM writer"])]
    (if (empty? (j/query config/cms ["SELECT nama FROM writer"]))
      '("")
      (map #(get % :nama) (j/query config/cms ["SELECT nama FROM writer"])))))


(defn list-of-id-category []
  (let [id (j/query config/cms ["SELECT idcategory FROM category"])]
    (if (empty? (j/query config/cms ["SELECT idcategory FROM category"]))
      '(0)
      (map #(get % :idcategory) (j/query config/cms ["SELECT idcategory FROM category"])))))


(defn list-of-id-writer []
  (let [id (j/query config/cms ["SELECT idwriter FROM writer"])]
    (if (empty? (j/query config/cms ["SELECT idwriter FROM writer"]))
      '(0)
      (map #(get % :idwriter) (j/query config/cms ["SELECT idwriter FROM writer"])))))

(defn insert-writer [nama bio foto]
 (j/insert! config/cms :writer
             {:idwriter (inc (apply max (list-of-id-writer))) :nama nama :bio bio :foto foto}))


(defn insert-post [title content category writer]
  (j/insert! config/cms :post
             {:idpost (inc (apply max (list-of-id-post))) :title title :body content :idcategory category :idwriter writer}))


(defn insert-category [category]
  (j/insert! config/cms :category
             {:idcategory (inc (apply max (list-of-id-category))) :nama category}))


(defn select-post []
  (j/query config/cms ["SELECT post.idpost,post.title,post.body, writer.nama, category.namacategory FROM post INNER JOIN writer ON post.idwriter=writer.idwriter LEFT OUTER JOIN category ON post.idcategory = category.idcategory"]))


(defn select-one-post [id]
  (j/query config/cms (vector (apply str (concat (str "SELECT * FROM post WHERE idpost='") (str id) (str "'"))))))


(defn select-one-writer [id]
  (j/query config/cms (vector (apply str (concat (str "SELECT * FROM writer WHERE idwriter='") (str id) (str "'"))))))

(defn select-one-writer-name [id]
  (j/query config/cms (vector (apply str (concat (str "SELECT nama FROM writer WHERE idwriter='") (str id) (str "'"))))))

(defn select-content-excerpt [length]
 (map #(assoc % :body (apply str (concat (take length (get % :body)) (apply str (repeat 12 ".")))))(select-post) ))

(defn category []
  (j/query config/cms ["SELECT * FROM category"]))

(defn writer []
  (j/query config/cms ["SELECT * FROM writer"]))

(defn delete-post [id]
  (j/delete! config/cms :post (vector (apply str (str "idpost = ?")) id)))

(defn edit-post [id body title idcategory idwriter]
  (j/update! config/cms :post (hash-map :title title :body body :idcategory idcategory :idwriter idwriter) (vector (apply str (str "idpost = ?")) id)))

(defn check-user [username password]
  (let [data (j/query config/cms (vector (apply str (concat (str "SELECT * FROM user WHERE username='") (str username) (str "'")))))]
    (if (empty? data )
    false
    (if (crypt/compare password (:password (first data)))
      true
      false))))
