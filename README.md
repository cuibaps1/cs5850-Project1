## Programming Assignment - iBox
### Purpose of the project: Assignment 1 for CS5850 Verification & Validation.
This project implements a prototype of a Dropbox application. The application specifies a folder on the hard drive to watch, and program detects the changes at runtime in the folder.

The Goal of this project is to focus on Unit Testing, Integration Test, Maven, CircleCI, Cobertura, CheckStyle and FindBugs.

## Installation
Clone the project

`git clone https://github.com/cuibaps1/cs5850-Project1.git`

## Test
For testing:

`mvn verify`

## Run:
Run the application

`javac App.java`

`java App @specifiedTheWatchedFolder`

## Functions
Select a folder on local drive to be used as the dropbox. A remote folder hosted on Google Cloud API will mirror the contents of the local folder.

Functions: Upload, Modify, Delete

## Plugs in
Cobertura
Checkstyle 
Findbugs
CircleCI
