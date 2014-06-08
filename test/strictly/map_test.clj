(ns strictly.map-test
  (:require [midje.sweet :refer :all]
            [strictly.map :refer [strict]]))

(fact "Attempting to get a missing key from a strict map throws an exception."
      (-> {:key :value} strict :key) => :value
      (->> {:key :value} strict :key) => :value
      (-> {:key :value} strict map?) => true 
      (-> {:key :value} strict (:foo :default)) => :default
      (-> {:key :value} strict (apply [:key])) => :value
      (-> {:key :value} strict (get :key)) => :value
      (-> {:key :value} strict (assoc :foo :bar) :foo) => :bar
      (-> {:key :value} strict vals) => [:value]
      (-> {:key :value} strict keys) => [:key]
      (-> {:key :value} strict seq) => [[:key :value]]
      (-> {:key :value} strict (= {:key :value})) => true 
      (-> {:key :value} strict (conj {:foo :bar}) :foo) => :bar
      (-> {:key :value} strict (merge {:foo :bar}) :foo) => :bar
      (-> {:key :value} strict (conj {:foo :bar}) :baz) => (throws RuntimeException) 
      (-> {:key :value} strict (merge {:foo :bar}) :baz) => (throws RuntimeException) 
      (-> {:key :value} strict :foo) => (throws RuntimeException)
      (-> {:key :value :nested {:foo :bar}} strict :nested :baz) => (throws RuntimeException)
      (-> {:key :value :nested {:foo :bar}} strict (:nested :default) :baz) => (throws RuntimeException))
