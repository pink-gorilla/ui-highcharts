(ns demo.page1.highcharts
  (:require
   [ui.highcharts :refer [highchart]]
   [goldly.page :as page]
   [demo.spec :refer [highchart-spec]]
   [demo.link :refer [link-href link-dispatch]]
   ))



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

    [link-href "/full" "highchart full (100%)"]
    ]])

(page/add highchart-page :user/highcharts)