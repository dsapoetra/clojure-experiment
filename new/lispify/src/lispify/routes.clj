(ns lispify.routes
  (:require [compojure.core :refer :all]
            [lispify.layout :as page]))

(defn homepage
  "The rendering function for homepage"
  []
  (page/render "base.html"
               {:headline "Welcome to Lispify! "
                :title "Luminoob website"}))

(defroutes home
  (GET "/" req
       (homepage)))
