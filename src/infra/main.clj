(ns infra.main
  (:gen-class)
  (:require [org.httpkit.server :refer [run-server]]
            [infra.routes :refer [app]]))

(def port 4000)

(defn -main[]
  (run-server app {:port port}))