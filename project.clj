(defproject strictly "0.1.0-SNAPSHOT"
  :description "Less tolerant Clojure."
  :url "https://github.com/ctford/strictly"
  :license {:name "MIT License"}
  :dependencies	[[org.clojure/clojure "1.8.0"]]
  :profiles {:dev
             {:plugins [[lein-midje "3.2.1"] ]
              :dependencies [[midje "1.8.3"]]}})
