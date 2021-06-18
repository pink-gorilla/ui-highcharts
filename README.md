# ui-highcharts [![GitHub Actions status |pink-gorilla/ui-highcharts](https://github.com/pink-gorilla/ui-input/workflows/CI/badge.svg)](https://github.com/pink-gorilla/ui-input/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/ui-input.svg)](https://clojars.org/org.pinkgorilla/ui-input)

[highcharts](https://www.highcharts.com)


https://github.com/highcharts/highcharts
https://www.highcharts.com/
https://api.highcharts.com/class-reference/Highcharts.Chart

## Demo

```
clojure -X:goldly
```

Navigate your webbrowser to port 8000. 
Snippets are in `running systems` / `snippet-registry`

## In Goldly as a ui extension

In deps.edn add ui-highcharts as dependency and add goldly alias

```
:goldly
  {:extra-deps {org.pinkgorilla/goldly {:mvn/version "RELEASE"}
               {org.pinkgorilla/ui-highcharts {:mvn/version "0.0.2"}}
   :exec-fn goldly-server.app/goldly-server-run!
   :exec-args {:profile "watch"
               :config {:goldly {:extensions [[pinkgorilla.highcharts.goldly]
                                              ]}}}}
```




