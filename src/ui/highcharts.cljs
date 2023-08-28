(ns ui.highcharts
  "Highchart renderer is a pure javascript renderer, the conversion
   of the spec as clj-data to javascript is done in the render-js component
   "
  (:require
   [clojure.set :refer [rename-keys]]
   ;["highcharts" :as highcharts]
   ["highcharts/highstock" :as highcharts] ; this brings ighstock and highcarts
   [pinkie.jsrender :refer [render-js]]))

(defn render-highchart [dom-node data]
  (highcharts/Chart. dom-node data); //.catch(console.warn);
  )

(defn ^{:category :data}
  highchart
  "reagent component to render highchart-spec via highcharts.js
   Usage:  [ui.highcharts/highchart spec-as-clj-data]"
  [spec]
  [render-js (assoc spec :f render-highchart)])

(defn render-highstock [dom-node data]
  (highcharts/stockChart. dom-node data); //.catch(console.warn);
  )

(defn ^{:category :data}
  highstock
  "reagent component to render highchart-spec via highcharts.js
   Usage:  [ui.highcharts/highchart spec-as-clj-data]"
  [spec]
  [render-js (assoc spec :f render-highstock)])




