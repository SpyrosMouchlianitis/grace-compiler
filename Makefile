build:
	export PATH=/usr/local/apache-maven-3.9.1/bin/:$PATH
	mvn compile
	mvn package

build-run:
	make build
	java -jar ./target/grace-compiler-0.1.0.jar

run:
	java -jar ./target/grace-compiler-0.1.0.jar