# Spring Boot API with Angular UI
 
This demo app shows how to create a Spring Boot backend to consume mock server response and display its data with an Angular UI.


**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Node.js](https://nodejs.org/).


## Getting Started

To install this application, run the following commands:

```bash
git clone https://github.com/7709989056/KLM_Travel_Project.git
cd KLM_Travel_Project
```

Import the project into IDE (preferred STS or IntelliJ). To install all of its dependencies and start app, follow the instructions below.

To run the springboot app, cd into the root of the project and run the below command:
 
```bash
./gradlew bootRun
```

To run the Angular client, cd into the project `KLM_Travel_Project/angular-klm` folder and run:
 
```bash
npm install then
npm start
```

Make sure Mock server is running on host: http://localhost:8080


If there are no errors then navigate to the page http://localhost:4200 and it should launch your application 'Travel Plan' default page


