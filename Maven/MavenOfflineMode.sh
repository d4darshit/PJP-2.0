#!/bin/bash
echo "Script to prevent maven from downloading dependencies every time /Make maven work without internet"
cd Desktop/PJP2/Maven_Project
mvn dependency:go-offline 
echo "Switching maven to offline mode" 
mvn -o clean install