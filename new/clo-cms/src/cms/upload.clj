(ns cms.upload
  (:use [compojure.core]
        [ring.middleware.params]
        [ring.middleware.multipart-params]
        [ring.adapter.jetty]
        [clojure.java.io]
        [hiccup.core])
  (:import [java.io File]))


#_(defn upload-file [file]
  (let [file-name (file :filename)
        size (file :size)]
    (do
      (copy actual-file (File. (format "/Users/dimassaputra/Code/git/clo-cms/resources/public/%s" file-name)))
      {:status 200
       :headers {"Content-Type" "text/html"}
       :body (html [:h1 file-name]
                   [:h1 size])})))

#_(defn upload-file [file]
  (let [file-name (file :filename)
        size (file :size)
        actual-file (file :tempfile)]
    (do
      (copy actual-file (File. (format "/Users/dimassaputra/Code/git/clo-cms/resources/public/%s" file-name)))
      {:status 200
       :headers {"Content-Type" "text/html"}
       :body (html [:h1 file-name]
                 [:h1 size])})))
