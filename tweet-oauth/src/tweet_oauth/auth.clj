(ns tweet_oauth.auth
  (require [oauth.client :as oauth]
           [clj-http.client :as http]))
(def consumer (oauth/make-consumer      <consumer-token>
                                       <consumer-token-secret>
                                        "https://api.twitter.com/oauth/request_token"
                                        "https://api.twitter.com/oauth/access_token"
                                        "https://api.twitter.com/oauth/authorize"
                                        :hmac-sha1))

 (defn request-token [] (oauth/request-token consumer "http://localhost:8080/hello/dimas"))

 (defn uri [] (oauth/user-approval-uri consumer
                                       (:oauth_token (request-token))))

 (defn access-token-response [] (oauth/access-token consumer
                                                    (request-token)))

 (defn credentials [] (oauth/credentials consumer
                                         (:oauth_token (access-token-response))
                                         (:oauth_token_secret (access-token-response))
                                         :POST
                                         "http://api.twitter.com/1.1/statuses/update.json"
                                         {:status "posting from #clojure with #oauth"}))
