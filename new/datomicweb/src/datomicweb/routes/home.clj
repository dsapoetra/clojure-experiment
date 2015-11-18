(ns datomicweb.routes.home
  (:require [datomicweb.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]
            [datomicweb.datom :as dt]
            [noir.response :as respons]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [input]
  (layout/render "home.html"
                 {:data (dt/eliminate input)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [input] (about-page input))
  (POST "/insert-act" [nama email alamat umur]
        (do
          (dt/add-data email nama alamat (Integer/parseInt umur))
          (respons/redirect "/")))
  (POST "/search-act" [input]
        (about-page input)))
