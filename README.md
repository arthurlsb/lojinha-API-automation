
# Lojinha API Automation
This is a repository that contains the automation of some API Rest tests of a software called Lojinha. The subtopics below describe some decisions made in structuring the project.

## Technologies Used
- Java:
  https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html
- JUnit:
  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.0-M1
- RestAssured:
  https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.4.0
- Maven:
  https://maven.apache.org/

## Automated Tests
Tests to validate the equivalence partitions related to the product's value in the Store, which are directly linked to the business rule that says that the product's value must be between BRL 0,01 and BRL 7.000,00.

## General notes
- We always use the Before Each annotation to capture the token that will be used later in the test methods
- We store the data that is sent to the API through the use of POJO classes
- We create initial data through the use of the Data Factory class, to facilitate its creation and control.
- In this project we use JUnit 5, which gives us the possibility to use the DisplayName annotation to give descriptions for our tests
