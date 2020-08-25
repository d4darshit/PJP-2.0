#!/bin/bash
echo "Script to print all maven goals"
cd Desktop/PJP2
mvn archetype:generate -DgroupId=com.orcos -DartifactId=Maven_Project -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
cd Maven_Project
echo "Maven project has been initialized"
mvn validate
echo "Project is validated"
mvn compile
echo "Project Compiled"
mvn  test
echo "Test phase has been completed. This phase does not require the code to be packaged"
mvn package
echo "Package goal executed and all source files are packaged into jar files"
mvn integration-test
echo "Process and deploy the package if necessary into an environment where integration tests can be run"
mvn verify
echo "Run any checks to verify the package is valid and meets quality criteria"
mvn install
echo "Dependencies downloaded to local repo"