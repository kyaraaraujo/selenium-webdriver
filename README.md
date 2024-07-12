# Selenium WebDriver - Frontend testing automation

The purpose of this project is to practice frontend testing automation using the framework Selenium WebDriver.


|   Java   |        Frameworks         |
|:--------:|:-------------------------:|
| min. 11  | Selenium WebDriver, JUnit |

## To run the project

1. Have an IDE (IntelliJ, VSCode, etc)
2. Have Java JDK
3. Clone the project and execute: mvn clean install

## Project structure
Packages:
- support: contains utilities to support the project and that can be used globally.
- scripts: contains the tests scripts
- pages: contains the pages representations as objects (with elements and methods)

This project uses the design pattern Page Object Model (POM) and Selenium Class PageFactory to support POM.
