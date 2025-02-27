
# Booking API Automation

This project is a REST API automation framework built using Java, Rest Assured, and Cucumber to validate booking API functionalities.

 
## Overview

This Booking API Automation project is a REST API automation framework built using Java, Rest Assured, and Cucumber to validate booking API functionalities.
## Features

Automated API Testing using Rest Assured

Behavior-Driven Development (BDD) with Cucumber

Schema Validation for API responses

Maven-based dependency management
## Prerequisites

#### Install:
Java 8 (Check with: java -version)

Maven (Check with: mvn -v)
## Setup Instructions

#### Clone the Repository
git clone 

https://github.com/gokila-appanasamy/Booking_API_Automation.git


#### Install Dependencies

mvn clean install

Give the base URI in application.properties


## Running Tests

#### Run Tests with Specific Cucumber Tags.
Example: @business or @happyPathScenario or @error
## Reporting

Cucumber Reports are generated at target/cucumber-reports/ This reports can be opened in a browser for better visualization.
## Maven Plugins Used

| Plugin             | Purpose                                                             |
| ----------------- | ------------------------------------------------------------------ |
| Maven Compiler Plugin | Compiles Java Code |
| Maven Surefire Plugin| Runs Cucumber Test|

## Tech Stack

| Technology             | Purpose                                                              |
| ----------------- | ------------------------------------------------------------------ |
| Java | Programming Language |
| Maven | Build & Dependency Management|
| Cucumber | BDD Test Framework|
| Rest Assured | API Automation |
| JSON Schema Validator | API Response Validation |
| Lombok | Reduces Boilerplate Code |

## Dependencies Overview

| Dependency             | Purpose                                                              |
| ----------------- | ------------------------------------------------------------------ |
| Cucumber Java | Step Definitions  |
| Cucumber JUnit | Test Execution |
| Rest Assured | API Automation |
| JSON Schema Validator | API Response Validation |
| Lombok | Reduces boilerplate code by using annotations |

## Benefits of this Framework

✔ BDD Approach - Improves test readability

✔ Schema Validation - Ensures API responses follow expected 
structure

✔ Tag-Based Execution - Run specific test groups easily
## Improvements
This framework can also be implemented with openApi for better enhancement
