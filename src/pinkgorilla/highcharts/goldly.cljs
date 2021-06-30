(ns pinkgorilla.highcharts.goldly
  (:require
   ; pinkie
   [pinkie.default-setup] ; side-effects
   [pinkie.pinkie :refer-macros [register-component]]

   ; helper fns
   [pinkgorilla.highcharts.core :refer [highchart highstock
                                        highchart-boxed highstock-boxed]]

;   
   ))

(register-component :p/highchart highchart)
(register-component :p/highstock highstock)

(register-component :p/highchartb highchart-boxed)
(register-component :p/highstockb highstock-boxed)
