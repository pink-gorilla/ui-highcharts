(ns demo.spec)

; this is our helper function to assemble a highchart object. it contains
; default values that we will use for multiple charts
(defn make-chart-config [data]
  {:chart {:type "line"
           :animation false
           ; zoom/pan
           :panKey "ctrl" ; "alt"" "shift"  "meta"
           :panning true
           ;:zoomType "xy"
           :zoomType "x"
           }
   :title {:text (:title data)}
   :subtitle {:text (:subtitle data)}
   :backgroundColor "blue"
   :yAxis {:min 0
           :title {:text ""
                   :align "high"}}
               ;:labels {:overflow "justify"}

   :xAxis {:categories (:labels data)
           :plotBands [{:color "rgba(255,75,66,0.07)"
                        :from 4
                        :to 5
                        :label {:text "forecast"}
                        :zIndex 1000}]}

   :tooltip {:valueSuffix " %"}
   :plotOptions {:series
                 {:animation 0
                  :label
                  {;:pointStart 2010
                   :connectorAllowed false}}}
   :legend {;:x -40
            ;:y 100
            ;:floating true
            ;:borderWidth 1
            ;:shadow true
            :layout "vertical"
            :align "right"
            :verticalAlign "top"}
   :credits {:enabled false}
   :series (:series data)})

(def highchart-spec
  (make-chart-config
   {:title "Economic Activity"
    :subtitle "made with Love"
    :labels ["Jan" "Feb" "Mar" "Apr" "May" "Jun" "Jul" "Aug"]
    :series
    [{:name "Installation" :data [439 523 577 698 931 1131 1333 1175]}
     {:name "Manufacturing" :data [249 244 292 291 390 302 381 404]}
     {:name "Sales & Distribution" :data [117 172 165 191 285 247 321 393]}
     {:name "range" :data [[100 320] [120 350] [160 370] [180 395] [280 490] [240 560] [300 430] [390 600]] :type "arearange"}
     ]}))
