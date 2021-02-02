#!/usr/bin/env bash
java -jar ../lib/code-generator-server-0.0.1-SNAPSHOT.jar -Xms2048m -Xmx2048m -XX:+HeapDumpOnOutOfMemoryError -XX:+UseG1GC 1>>../logs/main.log 2>>../logs/main.log &