.SILENT: run build clean
.DEFAULT_GOAL := build
FILEPATH=

build:
	mvn compile
	mvn package

run:
	if [ -z "${FILEPATH}" ]; then \
		echo "No filepath specified."; \
	elif [ "$${FILEPATH##*.}" != "grace" ]; then \
	    echo "Filepath must be a .grace file"; \
	else \
		java -jar ./target/grace-compiler-0.1.0.jar "${FILEPATH}"; \
	fi

clean:
	mvn clean install