build:
	mvn compile
	mvn package

build-run:
	make build
	java -jar ./target/grace-compiler-0.1.0.jar

run:
	java -jar ./target/grace-compiler-0.1.0.jar