# ECSE321-tutorial-3 Event-Registration

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

Step 1: Install the Spring Boot CLI 

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

Preparations: Sign up on [Heroku] (https://www.heroku.com/)

Install the command line client for Heroku: [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli)
