**Booking API Automation**
Overview:
This Booking API Automation project is a REST API automation framework built using Java, Rest Assured, and Cucumber to validate booking API functionalities.

**Features:**
Automated API Testing using Rest Assured
Behavior-Driven Development (BDD) with Cucumber
Schema Validation for API responses
Logging Support for better debugging
Maven-based dependency management

**Tech Stack**
Technology
Java -		Programming Language
Maven		- Build & Dependency Management
Cucumber	- BDD Test Framework
Rest Assured -	API Automation
JSON Schema Validator -	API Response Validation
Lombok	-	Reduces Boilerplate Code using annotations

**Prerequisites:**
Swagger Documentation
Install:
Java 8 and above (Check with: java -version)
Maven (Check with: mvn -v)

**Setup Instructions**
1️⃣ Clone the Repository
git clone https://github.com/gokila-appanasamy/Booking_API_Automation.git

2️⃣ Install Dependencies
mvn clean install

3️⃣ Configure the API Test Environment
Modify the base URL in application.properties

**Running Tests:**

Run Tests with Specific Cucumber Tags. Example: @happyPathScenarios

Test Reporting
Cucumber Reports are generated at target/cucumber-reports/
This reports can be opened in a browser for better visualization.

**Maven Plugins Used:**
Plugin	Purpose - Maven Compiler Plugin	Compiles Java code
Maven Surefire Plugin	- Runs Cucumber tests
Lombok Annotation Processor	- Enables Lombok support

**Dependencies Overview**
Cucumber Java	- Step Definitions
Cucumber JUnit	- Test Execution
Rest Assured -	API Automation
JSON Schema Validator -	Response Validation
Lombok	- Reduces boilerplate code by using annotations

**Benefits of this Framework**
✔ BDD Approach - Improves test readability
✔ Schema Validation - Ensures API responses follow expected structure
✔ Tag-Based Execution - Run specific test groups easily

**Improvements:**
This framework can also be implemented with openApi for better enhancement

