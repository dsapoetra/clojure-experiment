(ns cms.handler
  (:require [compojure.core :refer [defroutes routes wrap-routes]]
            [cms.layout :refer [error-page]]
            [cms.routes.home :refer [home-routes]]
            [cms.middleware :as middleware]
            [compojure.route :as route]
            [taoensso.timbre :as timbre]
            [taoensso.timbre.appenders.3rd-party.rotor :as rotor]
            [selmer.parser :as parser]
            [environ.core :refer [env]]
            [ring.middleware.session.memory :refer [memory-store]]
            [noir.session :as session]
            [compojure.handler :as handler]
             [hiccup.middleware :refer [wrap-base-url]]
             [cms.routes.home :refer [home-routes]]))

(defn init
  "init will be called once when
   app is deployed as a servlet on
   an app server such as Tomcat
   put any initialization code here"
  []

  (timbre/merge-config!
    {:level     (if (env :dev) :trace :info)
     :appenders {:rotor (rotor/rotor-appender
                          {:path "cms.log"
                           :max-size (* 512 1024)
                           :backlog 10})}})

  (if (env :dev) (parser/cache-off!))
  (timbre/info (str
                 "\n-=[cms started successfully"
                 (when (env :dev) " using the development profile")
                 "]=-")))

(defn destroy
  "destroy will be called when your application
   shuts down, put any clean up code here"
  []
  (timbre/info "cms is shutting down...")
  (timbre/info "shutdown complete!"))

(def app-routes
  (routes
    (wrap-routes #'home-routes middleware/wrap-csrf)
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))

(def app
  (-> (middleware/wrap-base #'app-routes)
  (session/wrap-noir-session
       {:store (memory-store)})))

#_(def app
  (-> (routes
       home-routes)
      (handler/site)
      (session/wrap-noir-session
       {:store (memory-store)})
      (wrap-base-url)))
