(ns infra.routes-test
  (:use clojure.test
        ring.mock.request
        infra.routes))

(deftest routes-status-codes
  (testing "unknown route"
    (let [response (app (request :get "/unknown-route"))]
      (is (= 404 (:status response)))))
  (testing "greeting"
    (let [response (app (request :get "/"))]
      (is (= 200 (:status response))))))