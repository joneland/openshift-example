(ns infra.routes
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.core :refer :all]
            [compojure.handler :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response]]
            [ring.middleware.json :refer :all]))

(defroutes app-routes
  (GET "/" []
    (response {:message "Hello!"}))
  (route/not-found
    (response {:message "Page not found!"})))

(def app
  (->
    app-routes
    compojure.handler/api
    wrap-json-response
    wrap-json-body))