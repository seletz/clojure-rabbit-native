# rmq-tool

This repository contains code where I expore clojure and native image building
in the scope of accessing RabbitMQ.  The ultimate goal is to have a
native-compiled RMQ tool for personal use.

## Development Setup

Note: Currently, I develop and test only on MacOS.

Install GraalVM and native image module:

``` bash
$ sdk install java 22.0.0.2.r17-grl
...
$ sdk use java 22.0.0.2.r17-grl
...
$ gu install native-image
$ export GRAALVM_HOME=$(sdk home java 22.0.0.2.r17-grl)
```

Install Clojure and Leinigen build tool:

``` bash
$ brew install clojure/tools/clojure
$ brew install leiningen
```

## Building and running

To run, use:

``` bash
$ lein run
...
```

To build a `uberjar`, do:

``` bash
$ lein uberjar
...
```

The uberjar is runnable:

``` bash
$ java -jar target/uberjar/rmq-tool-0.1.0-SNAPSHOT-standalone.jar
...
```

## Native Image

To build a native image, do:

``` bash
$ lein native-image
...
========================================================================================================================
Finished generating '/Users/seletz/develop/research/clojure-noob/target/default+uberjar/rmq-tool' in 32,8s.
Created native image /Users/seletz/develop/research/clojure-noob/target/default+uberjar/rmq-tool
$ ll target/default+uberjar
total 112072
drwxr-xr-x  6 seletz  staff   192B  6 Mär 20:00 classes
-rwxr-xr-x  1 seletz  staff    26M  6 Mär 20:01 rmq-tool
-rw-r--r--  1 seletz  staff    46B  6 Mär 20:01 rmq-tool.build_artifacts.txt
-rw-r--r--  1 seletz  staff    28M  6 Mär 20:01 rmq-tool.o
drwxr-xr-x  3 seletz  staff    96B  6 Mär 20:00 stale
```


