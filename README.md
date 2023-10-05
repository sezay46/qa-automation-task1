# qa-automation-task1

The project contains test and helper files that could be used to write automated tests with the help of cucumber and selenium webdriver.

## **Installation**

To run the tests in the project the following software should be installed on the machine:

+ <u>Java JDK v17</u>
+ <u>IntelliJ IDEA</u>
+ <u>Gradle v7.3.3</u>

## **Project preparation**

#### <u>Cloning the project</u>

+ You can clone the project through HTTPS with the following url: https://github.com/sezay46/qa-automation-task1.git
+ You can clone the project through SSH with the following: git@github.com:sezay46/qa-automation-task1.git

#### <u>Reload gradle project</u>

+ After you clone the project with the help of one of the above options then you need to open the project from Intellij IDEA and reload gradle project to import all of the dependencies

#### <u>Installing the plugins</u>

Also, to be able to use and work with cucumber files the following plugins need to be installed into IntelliJ IDEA.
+ Cucumber for Java plugin
+ Gherkin plugin

#### <u>Changing run test settings</u>

Problems could occur if the following setting is not set correctly:
+ File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle -> Run tests using -> <b>IntelliJ IDEA</b>

## **Tools**

+ Cucumber
+ Selenium WebDriver
+ Chrome driver

## **Test Execution**

In the project, to run the tests could be used runner class or directly form feature file.
+ The runner class is called CucumberTestRunner.class and its path is "src/test/java/runners/CucumberTestRunner.java"
+ The feature file is called SearchCar.feature and its path is "src/test/resources/features/SearchCar.feature"

## **Reporting**

Reports are creating after every execution. They are storing in the target folder. There are generating two types of reports:
+ HTML reports -> the file is called cucumber-html-report.html
+ JSON reports -> the file is called cucumber-json-report.json

<div style="text-align: right"> author: <i>Sezay Ismail</i> </div>
