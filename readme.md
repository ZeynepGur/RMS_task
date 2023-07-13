# PROJECT NAME 
RMS_task

This is a Maven project for testing API endpoints (provided by BBC team) using Cucumber, RestAssured, and Java. The tests are written in Gherkin format and executed using Cucumber.
# Requirements
The project is based on the following detailed requirement document provided by the BBC team. The document includes the API endpoints, required folders, and Automation scenarios.


# Tools
Based on the requirement, the following tools and framework were selected to create the automation framework:

- Programming Language: Java
- Build Tool: Apache Maven
- Testing Framework: Cucumber
- API Testing: Rest Assured
- IDE - Intellij IDEA

# Design
### Folder Structure
The project has the following folders:

- `runner` folder: Contains the Cucumber runner class `CukesRunner.java`, which specifies the configuration and location of feature files and step definitions. Also contains `FailedTestRunner` class which is responsible for handling and managing failed test cases during test execution.
- `stepdefinitions` folder: Contains the step definitions class `MediaApiStepDefs.java`, where the step definitions are defined for the Cucumber scenarios.
- `utilities` folder: Contains the utility class `ConfigurationReader.java`, which provides methods to read configuration properties (endpoint) from the `configuration.properties`
- `resources` folder: Contains the feature files in Gherkin format (`MediaApi.feature`)
- `pom.xml` file: Contains required dependencies and plugins

#### Dependencies
The project's `pom.xml` file includes the following dependencies & plugins:
- `cucumber-java` v.7.11.0
- `cucumber-junit` v.7.11.0
- `rest-assured` v.5.3.0 (There are few vulnerabilites from this dependency)
- `gson` v.2.8.9

- `maven-surefire-plugin` v.2.22.2 
- `maven-cucumber-reporting` v.5.0.0
# Development
The code implementation for the test scenarios is done in accordance with the requirements and design. The step definitions and feature files, based on the provided scenarios, are developed to cover the required test cases. Care has been taken to ensure readability, maintainability, and re-usability of the code.

In this project, a decision was made to use only one feature file due to the nature of the scenarios and the simplicity of the project. All the scenarios within the feature file utilize the same API response data, making it logical to group them together. 

In this project, a FailedTestRunner is used to record and retry failed test cases. Additionally, the maven-cucumber-reporting plugin generates an HTML report in the target folder at the end of the test run.

### Running instructions
*JDK and Maven required to run with below code*
- Download .zip file and 'Archive utility'
- navigate to root directory
```
cd C:\Path\to\Project
```

- run following command
```
mvn test
```



