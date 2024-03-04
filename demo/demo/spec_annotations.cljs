(ns demo.spec-annotations)


(def spec {:title {:text "Demo - Annotations"}
           :xAxis {:categories ["Jan" "Feb" "Mar"
                                "Apr" "May" "Jun"
                                "Jul" "Aug" "Sep"
                                "Oct" "Nov" "Dec"]}
           :annotations [{:labels [{:point "max"
                                    :text "MAX!"}
                                   {:point "min"
                                    :text "MIN!"
                                    :backgroundColor "white"}
                                   {:point {:x 0 :y 0} 
                                    :text "label"}
                                   ]}]
           :series [{:data [{:y 29.9 :id "min"}
                            71.5 106.4 129.2 144.0 176.0 135.6 148.5
                            {:y 216.4 :id "max"}
                            194.1 95.6 54.4]
                     
                     }]})

