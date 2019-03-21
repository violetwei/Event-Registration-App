# ECSE321-[Tutorial](https://mcgill-ecse321-winter2019.github.io/EventRegistration-Tutorials/) Event-Registration

## Description of Event Registration System

#### We assume that the following description is elicited from stakeholders (e.g., potential customers):

- The Event Registration System shall provide the ability to add a person by specifying the person’s name. This feature should be available in both a Web browser and an Android application.

- The Event Registration System shall provide the ability to add an event by specifying the event’s name, date, start time, and end time. This feature should be available in both a Web browser and an Android application.

- The Event Registration System shall provide the ability to register a person to an event. This feature should be available in both a Web browser and an Android application.

- The Event Registration System shall list all events in a Web browser.

- The Event Registration System shall list all persons in a Web browser.

- The Event Registration System shall list all events next to the person who is registered to it in a Web browser.

#### The target Event Registration System consists of three main components:

- :star2:Backend: It provides the core business functionality exposed as RESTful services by using the Java Spring Framework. In addition, it connects to a database to store business data.

- :star2:Web frontend: The web frontend needs to be developed in Vue.js, a popular framework using HTML5 and JavaScript for reactive user interfaces. The web frontend is connected to the backend via HTTP calls using the Rest API.

- :star2:Android frontend: The same backend services will also be accessed using an Android frontend application. Similarly, the Android frontend issues HTTP calls to call the backend.
