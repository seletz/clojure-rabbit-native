(defproject rmq-tool "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.slf4j/slf4j-api "1.7.30"]
                 [com.fzakaria/slf4j-timbre "0.3.21"]
                 [com.taoensso/timbre "5.1.2"]
                 [com.novemberain/langohr "5.1.0"]]

  :plugins [[io.taylorwood/lein-native-image "0.3.1"]]    ;; or in ~/.lein/profiles.clj

  :target-path "target/%s"
  :main rmq-tool.core

  :native-image {:name "rmq-tool"                 ;; name of output image, optional
                 ;; :graal-bin "/path/to/graalvm/" ;; path to GraalVM home, optional
                 :opts ["--report-unsupported-elements-at-runtime"
                        "--initialize-at-build-time"
                        "--allow-incomplete-classpath"
                        "--verbose"]}

  ;; optionally set profile-specific :native-image overrides
  :profiles {:uberjar {:aot :all}})
