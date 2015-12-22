; Copyright 2013 Relevance, Inc.
; Copyright 2014 Cognitect, Inc.

; The use and distribution terms for this software are covered by the
; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0)
; which can be found in the file epl-v10.html at the root of this distribution.
;
; By using this software in any fashion, you are agreeing to be bound by
; the terms of this license.
;
; You must not remove this notice, or any other, from this software.

(ns helloworld.service
  (:require [io.pedestal.http :as bootstrap]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.route.definition :refer [defroutes]]
            [ring.util.response :as ring-resp]
            [selmer.parser :as selmer]
            [clojure.string :as str]))

;; The home page is just a plain html page.
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

;; Define the routes that pull everything together.
(defroutes routes
  [[["/" {:get home-page} ^:interceptors [bootstrap/html-body]
      ["/selmer" {:get selmer-page}]]]])

;; Consumed by template-server.server/create-server
;; See bootstrap/default-interceptors for additional options you can configure
(def service {:env :prod
              ::bootstrap/routes routes
              ::bootstrap/resource-path "public/"
              ::bootstrap/type :jetty
              ::bootstrap/port 8080})
