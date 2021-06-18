(ns pinkgorilla.highcharts.core
  "Highchart renderer is a pure javascript renderer, the conversion
   of the spec as clj-data to javascript is done in the render-js component
   "
  (:require
   [clojure.set :refer [rename-keys]]
   ;["highcharts" :as highcharts]
   ["highcharts/highstock" :as highcharts]
   [pinkie.jsrender :refer [render-js]]
   [pinkgorilla.ui.box :refer [box]]))

;import Highcharts from 'highcharts/highstock

;<script src= "https://code.highcharts.com/stock/highstock.js" ></script>

;(println "highcharts: " highcharts)

(defn render-highchart [dom-node data]
  (highcharts/Chart. dom-node data); //.catch(console.warn);
  )

(defn ^{:category :data}
  highchart
  "reagent component to render highchart-spec via highcharts.js
   Usage:  [:p/highchart spec-as-clj-data]"
  [data]
  [render-js {:f render-highchart :data data}])

(defn render-highstock [dom-node data]
  (highcharts/stockChart. dom-node data); //.catch(console.warn);
  )

(defn ^{:category :data}
  highstock
  "reagent component to render highchart-spec via highcharts.js
   Usage:  [:p/highchart spec-as-clj-data]"
  [data]
  [render-js {:f render-highstock :data data}])

(defn highchart-box [data box]
  (let [s (-> (:style box)
              (select-keys  [:width-px :height-px])
              (rename-keys {:width-px :width
                            :height-px :height}))
        b (assoc data :chart s)
        ;b (assoc data :chart  {:width 300 :height 300})
        ]
    ;(println "highchart boxed: " b)
    b))

(defn ^{:category :data}
  highchart-boxed
  "reagent component to render highchart-spec via highcharts.js
   Usage:  [:p/highchart spec-as-clj-data]"
  [data]
  [box {:size :small
        :render-fn highchart
        :box-fn highchart-box
        :data data}])

(defn ^{:category :data}
  highstock-boxed
  "reagent component to render highchart-spec via highcharts.js
   Usage:  [:p/highchart spec-as-clj-data]"
  [data]
  [box {:size :small
        :render-fn highstock
        :box-fn highchart-box
        :data data}])


