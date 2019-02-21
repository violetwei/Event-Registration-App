# ECSE321-Tutorial Event-Registration

## Build and Deployment [tutorial](https://mcgill-ecse321-winter2019.github.io/EventRegistration-Tutorials/#_backend_with_spring_and_java_jpa)

### Gradle: A Build Framework

Writing a [Gradle](https://gradle.org/) build script that builds a single Gradle project referred to as Computation.

Create a folder called Computation, move sources and tests into that folder.

Produce the Gradle build script build.gradle within this folder to automate the software build process.

Open a terminal & Install the newest version of Gradle with gradle --version

1. Add the java and the application plugins to build configuration script build.gradle.

2. Add JUnit libraries to the dependencies section

3. Add and describe a new task compile(type: JavaCompile) to specify all source files (both application and test) and set the build/bin as destination dir to put all compiled class files in.

4. Specify the main class the run the application (In the command line issue gradle run)

5. Describe the jar Gradle task (defined by the java plugin) to produce an executable jar file into distributable/

### Set up a Spring/Spring Boot backend app with Gradle

Step 1: Install the [Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html#getting-started-installing-the-cli)

Step 2: Create a new repository named eventregistration

Step 3: Clone it to ~/git/event-registration

Step 4: Navigate to folder in terminal: cd ~/git/event-registration

Step 5: Create a project for the backend application using Spring Boot CLI in this repository.

Step 6: For future use, locate the application.properties file in the src/ folder and add the following content.

Step 7: Locate the Java file containing the main application class (EventRegistrationApplication.java) and add the following content.

Step 8: Verify that it builds with gradle build -xtest.

Step 9: Commit and push the files of the new Spring project.

git add .

git status #verify the files that are staged for commit

git commit -m "Initial commit of the backend application"

git push

## Heroku

#### Preparations: 

Sign up on [Heroku](https://www.heroku.com/)

Install the command line client for Heroku: [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli)
sudo npm install -g heroku

Log in to Heroku CLI by opening a terminal an typing: heroku login

### Create a Heroku app

Creat a Heroku application and deploy the Hello world! Spring example. 

The steps below will make it possible to store multiple different applications in the same git repository and deploy them individually to Heroku. 

Note: All actions described here for configuring Heroku applications using the Heroku CLI could also be done via the web UI.

1. Once logged in with the Heroku-CLI, create a new Heroku application: in the root of the git repository of your repository (assumed to be ~/git/eventregistration), issue heroku create eventregistration-backend-666 -n to create an application named "eventregistration-backend-666"

2. Add the multi procfile and Gradle buildpacks to the app.

### Add a database to the application

1. Open the Heroku applications web page and go to Resources, then add the Heroku Postgres add-on.

![jietu20190130-170825](https://user-images.githubusercontent.com/31902939/52019086-aeff6180-24ba-11e9-980e-6f7cfc070dce.jpg)

2. Click the entry for Postgres within the list of add-ons, then go to Settings. You can see the database credentials there.

## Backend with Spring and Java JPA

### Description of Event Registration System

### Domain modeling and code generation
- Installing UML Lab
- UML Lab project setup

### Setting up a Spring-based Backend
download the [Spring Tools Suite IDE](https://spring.io/tools)

- Running the Backend Application from Eclipse(SpringToolSuite)
- Spring Transactions
- Debugging: connecting to the database using a client

### CRUD Repositories and Services
- Creating a CRUD Repository
- Implementing Services

### Unit Testing the Backend Service

### RESTful Web Service for Spring Data JPA
- Preliminary
- Build RESTful Web Service
- Test the Service
- Build RESTful Web Service With Spring Data

#### Build RESTful Web Service Using Controller and DTOs

### Testing Backend Services
- Preperations
- Writing tests

#### Spring-based Backend Set up
![jietu20190130-170802](https://user-images.githubusercontent.com/31902939/52019087-af97f800-24ba-11e9-8122-933cc3a1fc86.jpg)


![jietu20190215-172251](https://user-images.githubusercontent.com/31902939/52887680-9e9be780-3146-11e9-8513-d0e1b57a6429.jpg)

JUnit Tests Passed!

![jietu20190215-165941](https://user-images.githubusercontent.com/31902939/52887681-9e9be780-3146-11e9-926a-a200cc6a9e65.jpg)
