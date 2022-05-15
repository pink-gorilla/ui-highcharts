; this is our helper function to assemble a highchart object. it contains
; default values that we will use for multiple charts
(defn make-chart-config [data]
  {:chart {:type "line"
           :animation false}
   :title {:text (:title data)}
   :subtitle {:text (:subtitle data)}
   :yAxis {:min 0
           :title {:text ""
                   :align "high"}}
               ;:labels {:overflow "justify"}

   :xAxis {:categories (:labels data)}
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
     {:name "Sales & Distribution" :data [117 172 165 191 285 247 321 393]}]}))

(defn link-fn [fun text]
  [:a.bg-blue-300.cursor-pointer.hover:bg-red-700.m-1
   {:on-click fun} text])

(defn link-dispatch [rf-evt text]
  (link-fn #(rf/dispatch rf-evt) text))

(defn link-href [href text]
  [:a.bg-blue-300.cursor-pointer.hover:bg-red-700.m-1
   {:href href} text])


(defn highchart-page  [{:keys [route-params query-params handler] :as route}]
  [:div
   ;[:div.text-green-300 "grid1"]

   [:div {:class "h-screen w-screen"} ; .grid.grid-cols-2
    [:div
     [link-href "/" "main"]
     [:p "highchart with different sizes"]]
    [link-dispatch [:css/set-theme-component :highcharts true] "default"]
    [link-dispatch [:css/set-theme-component :highcharts "dark-unica"] "dark-unica"]
    [link-dispatch [:css/set-theme-component :highcharts "grid-light"] "grid-light"]
    [link-dispatch [:css/set-theme-component :highcharts "sand-signika"] "sand-signika"]

    [:p "sm small"]
    [highchart {:data highchart-spec :box :sm}]

    [:p "md medium"]
    [highchart {:data highchart-spec :box :md}]

    [:p "lg large"]
    [highchart {:data highchart-spec :box :lg}]

    [:p "fl full (100%)"]
    [highchart {:data highchart-spec :box :fl}]]])

(add-page highchart-page :user/highcharts)