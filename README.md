# Weather Generator

[![Build Status](https://travis-ci.org/leandropadua/weathergenerator.svg?branch=master)](https://travis-ci.org/leandropadua/weathergenerator) [![codecov](https://codecov.io/gh/leandropadua/weathergenerator/branch/master/graph/badge.svg)](https://codecov.io/gh/leandropadua/weathergenerator)

The purpose of this App to generate weather data that can be consumed by games. All the generated data is printed on the standard output and errors are piped to error output.

For the current version, the data generated tries to simulate a planet that has similar weather conditions than Earth, but with different location names and continents. It's a planet called Searth (Simulated Earth).

## Setup
In order to build and execute this application is necessary to [install Maven](https://maven.apache.org/install.html).
```
Build => mvn clean install
Test => mvn test 
Run => mvn exec:java -q
```

## Notes

The games uses the configuration from config.json, in which is possible to set the number of weather data to be generated and if it is necessary to generate names for the locations. In the case which is requested to generate names, a file named locations.txt is used to get the names from. It can also be edited to introduce new names.

The generator is stateless and has a random effect to create different outputs every time it runs.
