(defproject cloweb "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.datomic/datomic-pro "0.9.5327"]
                 [lib-noir "0.9.9"]
                 [com.stuartsierra/component "0.3.0"]
                 [ring "1.4.0"]                             ;; http abstractions
                 [ring/ring-defaults "0.1.5"]               ;; http default settings
                 [http-kit "2.1.18"]                        ;; http server
                 [selmer "0.9.1"]
                 [ring/ring-anti-forgery "1.0.0"]])
