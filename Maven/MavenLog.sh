#!/bin/bash
echo "shell scripts to extract & save the build logs to a file instead of console output"
cd Desktop/PJP2/Maven_Project
touch log.txt
echo "Piping all the console output to LogFile.txt"
mvn clean install>LogFile.txt
