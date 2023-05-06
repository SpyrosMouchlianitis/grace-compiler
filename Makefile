MAVEN_PATH := $(shell echo "/usr/local/apache-maven-3.9.1/bin/")
export PATH := $(MAVEN_PATH):$(PATH)

.SILENT: run build clean
.DEFAULT_GOAL := build
FILEPATH=

build:
	mvn compile
	mvn package

run:
	if [ -z "${FILEPATH}" ]; then \
    	echo "No filepath specified."; \
    else \
    	java -jar ./target/grace-compiler-0.1.0.jar "${FILEPATH}"; \
    fi

clean:
	mvn clean install

