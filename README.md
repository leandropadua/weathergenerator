# Weather Generator

[![Build Status](https://travis-ci.org/leandropadua/weathergenerator.svg?branch=master)](https://travis-ci.org/leandropadua/weathergenerator) [![codecov](https://codecov.io/gh/leandropadua/weathergenerator/branch/master/graph/badge.svg)](https://codecov.io/gh/leandropadua/weathergenerator) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/74bd1634532b4215b0504b9cf9116162)](https://www.codacy.com/app/leandropadua/weathergenerator?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=leandropadua/weathergenerator&amp;utm_campaign=Badge_Grade)

The purpose of this App is to generate weather data that can be consumed by games. All the generated data is printed on the standard output and errors are piped to error output.

For the current version, the data generated tries to simulate a planet that has similar weather conditions than Earth, but with different location names and continents. It's a planet called Searth (Simulated Earth).

## Setup locally
In order to build and execute this application locally is necessary to [install Maven](https://maven.apache.org/install.html).
```
Build => mvn clean install
Test => mvn test 
Run => mvn exec:java -q
```

## Setup using docker
In order to run using docker, you can run from the public image available:
```
docker run leandropadua/weathergenerator
```

Alternatively, you can build the image and run it after built
```
docker build . -t weathergenerator
docker run weathergenerator
```

## Notes

The games uses the configuration from config.json, in which is possible to set the number of weather data to be generated and if it is necessary to generate names for the locations. In the case which is requested to generate names, a file named locations.txt is used to get the names from. It can also be edited to introduce new names.

The generator is stateless and has a random effect to create different outputs every time it runs.
