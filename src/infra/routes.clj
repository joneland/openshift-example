(ns infra.routes
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.core :refer :all]
            [compojure.handler :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response]]))

(defroutes app-routes
  (->
    (route/not-found
      (response {:message "Page not found!"}))))

(def app
  (->
    app-routes
    compojure.handler/api))