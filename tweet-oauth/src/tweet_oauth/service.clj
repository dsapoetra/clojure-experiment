(ns tweet-oauth.service
  (:require [io.pedestal.http :as bootstrap]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route.definition :refer [defroutes]]
            [ring.util.response :as ring-resp]
            [selmer.parser :as selmer]
            [clojure.string :as str]
            [tweet_oauth.auth :as auth]))

(defn about-page
  [request]
  (ring-resp/response (format "Clojure %s - served from %s"
                              (clojure-version)
                              (route/url-for ::about-page))))

(defn home-page
  [request]
  {:status 200 :body "home"})

;; The /selmer page uses selmer.
;; https://github.com/yogthos/Selmer
(defn selmer-page
  [request]
  (ring-resp/response
   (selmer/render-file "html/index.html"
                               {:title "ini selmer"
                                :text  "Ha Ha! I'm Selmer."
                                :date  "tanggal"})))

(defn hello-who [req]
  (let [who (get-in req [:path-params :who])]
    (ring.util.response/response (str "Hello " who))))

(defn requ [req]
  {:status 200 :body (str req)})

(defn autho [req]
  (ring-resp/redirect (auth/uri)))

;; Define the routes that pull everything together.
(defroutes routes
  [[["/" {:get selmer-page} ^:interceptors [bootstrap/html-body]
      ["/hello/:who" {:get hello-who}]
      ["/auth" {:get autho}]]]])

;; Consumed by tweet-oauth.server/create-server
;; See bootstrap/default-interceptors for additional options you can configure
(def service {:env :prod
              ;; You can bring your own non-default interceptors. Make
              ;; sure you include routing and set it up right for
              ;; dev-mode. If you do, many other keys for configuring
              ;; default interceptors will be ignored.
              ;; ::bootstrap/interceptors []
              ::bootstrap/routes routes

              ;; Uncomment next line to enable CORS support, add
              ;; string(s) specifying scheme, host and port for
              ;; allowed source(s):
              ;;
              ;; "http://localhost:8080"
              ;;
              ;;::bootstrap/allowed-origins ["scheme://host:port"]

              ;; Root for resource interceptor that is available by default.
              ::bootstrap/resource-path "/public"

              ;; Either :jetty, :immutant or :tomcat (see comments in project.clj)
              ::bootstrap/type :jetty
              ;;::bootstrap/host "localhost"
              ::bootstrap/port 8080})
