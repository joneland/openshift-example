(set-env!
  :source-paths #{"src", "test"}
  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [http-kit "2.2.0"]
                  [compojure "1.5.1"]
                  [ring/ring-core "1.5.0"]
                  [ring/ring-jetty-adapter "1.5.0"]
                  [ring/ring-json "0.4.0"]
                  [adzerk/boot-test "1.1.2" :scope "test"]
                  [ring/ring-mock "0.3.0" :scope "test"]
                  [onetom/boot-lein-generate "0.1.3" :scope "test"]])

(require '[boot.lein])
(boot.lein/generate)

(task-options!
  pom {:project 'openshift-example
       :version "0.1.0"}
  jar {:main 'infra.main}
  aot {:all true})

(require '[adzerk.boot-test :refer :all])

(deftask build
  "Test & build uber jar"
  []
  (comp
    (adzerk.boot-test/test)
    (aot)
    (pom)
    (uber)
    (jar)
    (target)))