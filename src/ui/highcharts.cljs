(ns ui.highcharts
  "Highchart renderer is a pure javascript renderer, the conversion
   of the spec as clj-data to javascript is done in the render-js component"
  (:require
   ;["highcharts" :as highcharts] ; highstock includes highcharts
   ["highcharts/highstock" :as highcharts] ; this brings highstock and highcharts
   ["highcharts/highcharts-more" :as more]
   ["highcharts/modules/annotations" :as annotations] ; annotation module
   ["highcharts/modules/boost" :as boost]
   ["highcharts/modules/debugger" :as debugger]
   [pinkie.jsrender :refer [render-js]]))

;; highcharts modules:
; accessibility full-screen no-data-to-display         
; arrow-symbols drag-panes stock stock-tools
; annotations annotations-advanced
; boost boost-canvas data
; export-data exporting debugger
; dependency-wheel heikinashi parallel-coordinates      
; sunburst dotplot histogram-bellcurve pareto tilemap
; draggable-points hollowcandlestick pathfinder timeline
; item-series pattern-fill treegrid drilldown lollipop                   
; price-indicator treemap dumbbell map pyramid3d variable-pie
; broken-axis marker-clusters sankey variwide bullet streamgraph
; networkgraph series-label vector coloraxis solid-gauge              
; venn current-date-indicator funnel3d offline-exporting         
; sonification windbarb cylinder funnel oldie static-scale              
; wordcloud oldie-polyfills datagrouping gantt xrange
; grid-axis organization heatmap overlapping-datalabels     

(defn add-annotations []
  (println "adding highcharts annotation feature..")
  (annotations highcharts))

(defn add-boost []
  (println "adding highcharts boost feature..")
  (boost highcharts))

(defn add-debugger []
  (println "adding highcharts debugger feature..")
  (debugger highcharts))

(defn add-more []
  (println "adding highcharts more feature..")
  (more highcharts))

(defonce loaded? (atom false))

(defn ensure-extensions-loaded []
  (when-not @loaded?
    (reset! loaded? true)
    (add-debugger)
    (add-boost)
    (add-annotations)
    (add-more)))

(defn render-highchart [dom-node data]
  (ensure-extensions-loaded)
  (highcharts/Chart. dom-node data); //.catch(console.warn);
  )

(defn ^{:category :data}
  highchart
  "reagent component to render highchart-spec via highcharts
   Usage:  [ui.highcharts/highchart spec-as-clj-data]"
  [spec]
  [render-js (assoc spec :f render-highchart)])

(defn render-highstock [dom-node data]
  (ensure-extensions-loaded)
  (highcharts/stockChart. dom-node data); //.catch(console.warn);
  )

(defn ^{:category :data}
  highstock
  "reagent component to render highchart-spec via highcharts
   Usage:  [ui.highcharts/highchart spec-as-clj-data]"
  [spec]
  [render-js (assoc spec :f render-highstock)])




