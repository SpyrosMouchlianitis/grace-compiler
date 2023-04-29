MAVEN_PATH := $(shell echo "/usr/local/apache-maven-3.9.1/bin/")
export PATH := $(MAVEN_PATH):$(PATH)

.DEFAULT_GOAL := build

build:
	mvn compile
	mvn package

build-run:
	make build
	java -jar ./target/grace-compiler-0.1.0.jar

run:
	java -jar ./target/grace-compiler-0.1.0.jar

clean:
	mvn clean install

