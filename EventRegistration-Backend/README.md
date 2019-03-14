# EventRegistration-Backend

## Tutorial Section 2: Build and Deployment 

### :star2:Gradle: A Build Framework

Writing a [Gradle](https://gradle.org/) build script that builds a single Gradle project referred to as Computation.

Create a folder called Computation, move sources and tests into that folder.

Produce the Gradle build script build.gradle within this folder to automate the software build process.

Open a terminal & Install the newest version of Gradle(ver. 5.0+) with ```gradle --version```

1. Add the ```java``` and the ```application``` plugins to build configuration script ```build.gradle```.
```
apply plugin: 'java'
// This plugin has a predefined 'run' task that we can reuse to use Gradle to execute our application
apply plugin: 'application'
```

2. Add JUnit libraries to the ```dependencies``` section
```
repositories {
    mavenCentral()
}
dependencies {
    testImplementation "junit:junit:4.12"
}
```

3. Add and describe a new task ```compile(type: JavaCompile)``` to specify all source files (both application and test) and set the build/bin as destination dir to put all compiled class files in.
```
task compile(type: JavaCompile) {
  classpath = sourceSets.main.compileClasspath
  classpath += sourceSets.test.runtimeClasspath
  sourceSets.test.java.outputDir = file('build/bin')
  sourceSets.main.java.outputDir = file('build/bin')
}
```
```
/*
 * specifying sourceSets is not necessary in this case, since
 * we are applying the default folder structure assumed by Gradle
 */
sourceSets {
  main {
    java { srcDir 'src/main/java' }
  }
  test {
    java { srcDir 'src/test/java'}
  }
}
```

4. Specify the main class the run the application (In the command line issue ```gradle run```)
```mainClassName='application.CompApp'```

5. Describe the ```jar``` Gradle task (defined by the ```java``` plugin) to produce an executable jar file into ```distributable/```
```
jar {
  destinationDir=file('distributable')
  manifest {
    // It is smart to reuse the name of the main class variable instead of hardcoding it
    attributes "Main-Class": "$mainClassName"
  }
}
```

### :star:Set up a Spring/Spring Boot backend app with Gradle

Step 1: Install the [Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html#getting-started-installing-the-cli)

Step 2: Create a new repository named eventregistration

Step 3: Clone it to ~/git/event-registration

Step 4: Navigate to folder in terminal: ```cd ~/git/event-registration```

Step 5: Create a project for the backend application using Spring Boot CLI in this repository.
```
spring init \
 --build=gradle \
 --java-version=1.8 \
 --package=ca.mcgill.ecse321.eventregistration \
 --name=EventRegistration \
 --dependencies=web,data-jpa,postgresql \
 EventRegistration-Backend
 ```

Step 6: For future use, locate the ```application.properties``` file in the src/ folder and add the following content:
```
server.port=${PORT:8080}

spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect
```
Step 7: Locate the Java file containing the **main application class** (```EventRegistrationApplication.java```) and add the following content.
```
package ca.mcgill.ecse321.eventregistration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class EventRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventRegistrationApplication.class, args);
	}

  @RequestMapping("/")
  public String greeting(){
    return "Hello world!";
  }
}
```

Step 8: Verify that it builds with ```gradle build -xtest```.

Step 9: Commit and push the files of the new **Spring project**.
```
git add .

git status #verify the files that are staged for commit

git commit -m "Initial commit of the backend application"

git push
```

## Heroku

#### Preparations: 

Sign up on [Heroku](https://www.heroku.com/)

Install the command line client for Heroku: [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli)
sudo npm install -g heroku

Log in to Heroku CLI by opening a terminal an typing: ```heroku login```

### :star:Create a Heroku app

Creat a Heroku application and deploy the Hello world! Spring example. 

The steps below will make it possible to store multiple different applications in the same git repository and deploy them individually to Heroku. 

Note: All actions described here for configuring Heroku applications using the Heroku CLI could also be done via the web UI.

1. Once logged in with the Heroku-CLI, create a new Heroku application: in the root of the git repository of your repository (assumed to be ~/git/eventregistration), issue ```heroku create eventregistration-backend-666 -n``` to create an application named "eventregistration-backend-666"

2. Add the multi procfile and Gradle buildpacks to the app.
```
heroku buildpacks:add -a eventregistration-backend-<UNIQUE_ID> https://github.com/heroku/heroku-buildpack-multi-procfile
heroku buildpacks:add -a eventregistration-backend-<UNIQUE_ID> heroku/gradle
```

### :star:Add a database to the application

1. Open the Heroku applications web page and go to *Resources*, then add the Heroku Postgres add-on.

![jietu20190130-170825](https://user-images.githubusercontent.com/31902939/52019086-aeff6180-24ba-11e9-980e-6f7cfc070dce.jpg)

2. Click the entry for Postgres within the list of add-ons, then go to *Settings*. You can see the database credentials there.

### :star:Extending the build for the Heroku deployment environment
1. Before deploying, a top level *build.gradle* and *settings.gradle* need to be created in the root of the repository (i.e., in ~/git/eventregistration)

build.gradle:
```
task stage () {
    dependsOn ':EventRegistration-Backend:assemble'
}
```
settings.gradle:
```include ':EventRegistration-Backend'```

2. Generate the **Gradle wrapper** with the newest Gradle version
```gradle wrapper --gradle-version 5.1.1```

3. Create a *.gitignore* file for the *.gradle* folder:

.gitignore:
```.gradle/```

4. Add all new files to git
```
git add .
git status #make sure that files in .gradle/ are not added
```
```git status```

Commit changes:

```git commit -m "Adding Gradle wrapper"```

### :star:Supply application-specific setting for heroku
1. Within the *EventRegistration-Backend* folder, create a file called Procfile (not Procfile.txt, name it exactly Procfile) with the content:
```
web: java -jar EventRegistration-Backend/build/libs/EventRegistration-Backend-0.0.1-SNAPSHOT.jar
```
2. Add the Procfile to a new commit

3. **Configure** the multi-procfile buildpack to find the Procfile:
```heroku config:add PROCFILE=EventRegistration-Backend/Procfile --app eventregistration-backend-<UNIQUE_ID>```

### :star2:Deploying the app

1. Obtain and copy the *Heroku Git URL*
```heroku git:remote --app eventregistration-backend-<UNIQUE_ID>```

Output:

```set git remote heroku to https://git.heroku.com/eventregistration-backend-<UNIQUE_ID>.git```

2. Add the ```backend-heroku``` remote and deploy the first version of the application with
```
git remote add backend-heroku https://git.heroku.com/eventregistration-backend-<UNIQUE_ID>.git
git push backend-heroku master
```

3. Visit the link provided in the build output. It may take some time (even 30-60 seconds) for the server to answer the first HTTP request, so be patient!

4. Save your work to the GitHub repository, too: ```git push origin master```



## Tutorial Section 3: Backend with Spring and Java JPA

### Description of Event Registration System

We assume that the following description is elicited from stakeholders (e.g., potential customers):

- The Event Registration System shall provide the ability to add a person by specifying the person’s name. This feature should be available in both a Web browser and an Android application.

- The Event Registration System shall provide the ability to add an event by specifying the event’s name, date, start time, and end time. This feature should be available in both a Web browser and an Android application.

- The Event Registration System shall provide the ability to register a person to an event. This feature should be available in both a Web browser and an Android application.

- The Event Registration System shall list all events in a Web browser.

- The Event Registration System shall list all persons in a Web browser.

- The Event Registration System shall list all events next to the person who is registered to it in a Web browser.

:star2:The target Event Registration System consists of three main components:

- **Backend**: It provides the core business functionality exposed as RESTful services by using the Java Spring Framework. In addition, it connects to a database to store business data.

- **Web frontend**: The web frontend needs to be developed in Vue.js, a popular framework using HTML5 and JavaScript for reactive user interfaces. The web frontend is connected to the backend via HTTP calls using the Rest API.

- **Android frontend**: The same backend services will also be accessed using an Android frontend application. Similarly, the Android frontend issues HTTP calls to call the backend.

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
