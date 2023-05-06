# Grace Compiler
A compiler for the Grace programming language

## Installation
- First you need to make sure you have maven installed. Check [this](https://maven.apache.org/install.html) for instructions.
- After installing maven you will need to install make. If you don't have it already, run the following:
  ```
  sudo apt-get update
  sudo apt-get install make
  ```
  Make sure it was installed correctly `make -v`. You should see the version of Make.

## Usage
```
# compile the project
make

# run the parser (change the value of FILEPATH to the path of your file)
make run FILEPATH=./examples/hello_world.grace

# clean install
make clean
```

# IMPORTANT NOTE
In the example codes provided there is a mistake on line 30 of the bubblesort code. It's missing a semicolon.
This will result in an error during parsing. To avoid it either comment out the line or enter the missing semicolon.