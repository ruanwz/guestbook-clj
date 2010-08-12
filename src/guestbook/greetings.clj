(ns guestbook.greetings
  (:require [appengine.datastore :as ds])
  (:import (com.google.appengine.api.datastore Query)))


(defn create [content author]
  (ds/create-entity {:kind "Greeting" :author author :content content :date (java.util.Date.)}))

(defn find-all []
  (ds/find-entity (doto (Query. "Greeting") (.addSort "date"))))
