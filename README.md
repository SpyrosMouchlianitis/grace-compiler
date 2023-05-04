# Grace Compiler
A compiler for the Grace programming language

## Requirements
- First you need to make sure you have maven installed. Check [this](https://maven.apache.org/install.html) for instructions.
- After installing maven you will need to install make. If you don't have it already, run the following:\
  `sudo apt-get update`\
  `sudo apt-get install make`\
  Make sure it was installed correctly `make -v`. You should see the version of Make.

## Usage
- Run `make` to compile the project.
- Run  `make run` to run the parser.
- Run `make clean` to do a clean install.

## Known Issues 
- Escape characters in single quotes e.g '\0' are not recognised