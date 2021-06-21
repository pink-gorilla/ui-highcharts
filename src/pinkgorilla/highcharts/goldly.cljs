(ns pinkgorilla.highcharts.goldly
  (:require
   [re-frame.core :as rf]

   ; pinkie
   [pinkie.default-setup] ; side-effects
   [pinkie.pinkie :refer-macros [register-component]]

   ; helper fns
   [pinkgorilla.highcharts.css :as css]
   [pinkgorilla.highcharts.core :refer [highchart highstock
                                        highchart-boxed highstock-boxed]]

;   
   ))

(rf/dispatch [:css/add-components css/components css/config])

(register-component :p/highchart highchart)
(register-component :p/highstock highstock)

(register-component :p/highchartb highchart-boxed)
(register-component :p/highstockb highstock-boxed)
