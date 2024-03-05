(ns demo.spec-annotations)

(def spec {:title {:text "Demo - Annotations"}
           :xAxis {:categories ["Jan" "Feb" "Mar"
                                "Apr" "May" "Jun"
                                "Jul" "Aug" "Sep"
                                "Oct" "Nov" "Dec"]
                   :plotBands [{:color "rgba(255,75,66,0.07)"
                                :from 4
                                :to 6
                                :label {:text "forecast"}
                                :zIndex 1000}]}

           :annotations [{:labels [{:point "max":text "MAX!" :backgroundColor "red"}
                                   {:point "min" :text "MIN!" :backgroundColor "white"}
                                   {:point {:x 9 :y 150 :xAxis 0 :yAxis 0} :text "label"}]
                          :shapes [{:type "path"
                                    :strokeWidth 5
                                    :backgroundColor "blue"
                                    :fill "blue"
                                    :points [{:x 3 :y 105 :xAxis 0 :yAxis 0}
                                             {:x 3 :y 145 :xAxis 0 :yAxis 0}
                                             {:x 5 :y 145 :xAxis 0 :yAxis 0}
                                             {:x 5 :y 105 :xAxis 0 :yAxis 0}]}]}]

           :series [{:data [{:y 29.9 :id "min"}
                            71.5 106.4 129.2 144.0 176.0 135.6 148.5
                            {:y 216.4 :id "max"}
                            194.1 95.6 54.4]}]})

