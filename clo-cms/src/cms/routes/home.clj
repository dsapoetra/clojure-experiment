(ns cms.routes.home
  (:require [cms.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [ring.util.response :as resp]
            [clojure.java.io :as iona]
            [cms.sql_query :as query]
            [cms.upload :as upload]
            [noir.io :as io]
            [noir.util.crypt :as crypt]
            [noir.session :as session]))


(def resource-path "/Users/dimassaputra/Code/git/clo-cms/resources/public/img/")

(defn home-page []
  (layout/render
    "home.html" {:data (query/select-content-excerpt 400)
                 :category (query/category)}))

(defn about-page []
  (layout/render
    "about.html" {:data (query/select-content-excerpt 400)
                 :category (query/category)}))

(defn bo-page []
  (layout/render "bo.html"))

(defn list-post-page []
  (layout/render
    "list-post.html" {:data (query/select-content-excerpt 400)}))

(defn editor-page []
  (layout/render
   "editor.html" {:data (query/category)
                  :data2 (query/writer)}))

(defn editor-post-page [id]
  (layout/render
   "edit-post.html" {:dat(query/select-one-post id)
                     :cat (query/category)
                     :data2 (query/writer)}))

(defn writer-page []
  (layout/render
   "writer.html" {:data (query/writer)}))

(defn category-page []
  (layout/render
   "category.html" {:data (query/category)}))


(defn full-article [id]
  (layout/render
   "page.html" {:dat(query/select-one-post id)
                :penulis (query/select-one-writer (get (first (query/select-one-post id)) :idwriter))}))


(defroutes home-routes
   (GET "/" [] (home-page))
   (GET "/about" [] (about-page))
   (GET "/post/:id" [id] (full-article id))
   (GET "/bo" []
       (bo-page))
  (GET "/editor" []
     (if (session/get :username)
       (editor-page)
       (resp/redirect "/bo")))
  (POST "/submit" [title content idcategory idwriter]
     (if (session/get :username)
        (do
           (query/insert-post title content idcategory idwriter )
            (resp/redirect "/"))
        (resp/redirect "/bo")))
  (POST "/submit-category" [category]
      (if (session/get :username)
         (if (some #(= category %) (query/list-of-category))
             (resp/redirect "category")
             (do
                (query/insert-category category)
                (resp/redirect "/category")))
          (resp/redirect "/bo")))
  (GET "/edit/post/:id" [id]
       (if (session/get :username)
                  (editor-post-page id)
                  (resp/redirect "/bo")) )
  (GET "/writer" []
       (if (session/get :username)
                 (writer-page)
                  (resp/redirect "/bo")))
  (GET "/category" [] (category-page)
        (if (session/get :username)
                  (category-page)
                  (resp/redirect "/bo")))
   (GET "/list-post" [] (list-post-page)
         (if (session/get :username)
                  (list-post-page)
                  (resp/redirect "/bo")))
   (POST "/upload" [nama bio file]
        ;; file with same name will be overwrited, so in production mode , gen a
        ;; random string as filename
          (if (session/get :username)
                  (do
                  (io/upload-file resource-path file)
                  (query/insert-writer nama bio (str "/img/" (:filename file)))
       (resp/redirect "/writer"))
                  (resp/redirect "/bo")))
   (GET "/delete-post/:id" [id]
         (if (session/get :username)
                  (do
          (query/delete-post id)
          (resp/redirect "/list-post"))
                  (resp/redirect "/bo")))
   (POST "/update/:id" [id content idcategory idwriter title]
          (if (session/get :username)
                  (do
           (query/edit-post id content title idcategory idwriter)
           (resp/redirect "/"))
                  (resp/redirect "/bo")))
   (POST "/login-act" [username password]
         (if (query/check-user username password)
           (do
             (session/put! :username username)
             (resp/redirect "/editor"))
           (resp/redirect "/bo")))
   (GET "/logout" []
                  (do
                    (session/clear!)
                    (resp/redirect "/bo"))))
