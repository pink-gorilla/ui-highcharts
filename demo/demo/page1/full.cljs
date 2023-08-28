(ns demo.page1.full
  (:require
   [ui.highcharts :refer [highchart]]
   [goldly.page :as page]
   [demo.spec :refer [highchart-spec]]))

(defn highchart-full-page  [{:keys [route-params query-params handler] :as route}]
  [:div
   ;[:div.text-green-300 "grid1"]
   [:div {:class "h-screen w-screen"} ; .grid.grid-cols-2
     [highchart {:data highchart-spec :box :fl}]
   ]])


(page/add highchart-full-page :user/highcharts-full)