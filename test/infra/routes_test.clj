(ns infra.routes-test
  (:use clojure.test
        ring.mock.request
        infra.routes))

(deftest routes
  (testing "unknown route"
    (let [response (app (request :get "/unknown-route"))]
      (is (= 404 (:status response))))))