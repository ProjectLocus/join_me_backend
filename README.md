A social media invitation app with a focus on connecting people on a human level by allowing users 
to send invitations to other people to do actual events such as enjoy a cup of coffee or attend an office party.
Amongst all of the social media apps out there that are connecting people with others across the world,
our app has the fine opportunity of connecting people on a more intimate level. Not across the world,
but maybe across the street. 

The files in this repository are for building the backend in IntelliJ Idea using a Spring Boot framework. The backend is completed and fully functional for supporting the functions of the frontend.  There are no known bugs in the backend, which has been tested on locally deployed machines as well as on Amazon Web Services Elastic Beanstalk. There are no known devices that the backend cannot be run on, providing that the machine can run IntelliJ Idea. 

The API endpoints currently return superfluous information. Stretch goals include fixing the API endpoints to return only the needed information and nothing extra.  An additional stretch goal is to support keeping an internal list of all persons who have accepted a particular invitation as well as implementing functionality that would allow for "degrees of separation", meaning that an invitation could be resent by its recipients a certain number of times.

Here's our [Apache 2.0 License](https://github.com/ProjectLocus/JoinMe/blob/master/LICENSE)

## Team Members:
* **Alex Rael**:
Did most of the Room Persistence ORM manipulation throughout the app. That includes grabbing the necessary
information to create a new user from Google Sign In, displaying that info in the user profile section including a users
display name and display image, grabbing info from the create invitation fragment including the location of the event and the
date and time of the event and displaying it in a new invitation view for the user who receives it. Also setup most of the Retrofit calls to communicate with the backend.

* **Dina Rabanal**:
I created recycler views for the people and invitations fragments. Making the basic recycler knowing
that it would expand into backend use of the list of people in each quadrant. I also concentrated on the UI design.
I believe that the look of the app is just as important as design of the code.

* **Brian Bleck**:
Built the back-end using the Spring Boot Framework (Tomcat, Spring MVC, Spring Security, and Spring HATEOAS) and deployed it onto AWS Elastic Beanstalk. The database is an Apache Derby database and Hibernate was used as the ORM layer on top of it. The Jackson library was used to serialize/deserialize the data coming from/to the back-end. Created the early architectural bones for the front-end to be fleshed out around. Troubleshot data transfer issues between client/server. For the client, coded the location updates and the data update loop to keep the front end connected to the back-end. Coded the logic to maintain the client database with the correct data. Coded the client logic for packaging incoming data for use in the various UI elements, and the client logic for packaging data and making calls to the back-end. 

## User Stories:
* As a user I want to be able to send an invitation to other people who I can see.
  * As a user I want to be able to invite one other person out to coffee.
  * As a leader of an organization I want to be able to invite everyone in a meeting to lunch.
  * As a user I want to be able to connect with new people in close proximity.
* As a senior I want to be able to alert people around me that I am in need of medical attention.
  * As a user I want to be able to alert people in the immediate vicinity that I am in danger.
  * As a user I want to be able to alert people of a fire.
* As a user I want to able to receive invitations from other users.
* As a store owner I want to be able to inform users of current sales.
  * As a bar owner I want to be able to inform users of bar events.
* As a community organizer I want to be able to alert people that there is a rally coming together.
* As a student I want to be able to invite my friends to a party.
* As a user I want to be able to drop down an event in an area for people to see within that are.
  * As a user I want to be able to see events dropped down by other users within the same area.
* As a user I want to be able to tell everyone that I've lost my pet.
  * As a user I want to be able to tell everyone that I have a gig going on.

## Wireframes:
A link to our Join Me [wireframes](https://xd.adobe.com/view/d6ac88a3-27a0-472c-4504-44abbed3cf8b-a09d/).

## Technical Information:
The app was developed in mostly English with a restricted Portrait orientation. Operating Systems
developed in were Windows and OSx. Software used includes both IntelliJ and Android Studio. Project
was developed in Java 8 and the app had a minimum SDK level of 23 but has been tested to work on
SDKs 24-28. Most test were ran on both emulators and physical android devices that run at least
Marshmellow.

## Main Server Endpoint (relative to server):

... /rest/people

[API documentation](https://github.com/ProjectLocus/join_me_backend/blob/master/docs/rest/api.md)

There is no public server which hosts the backend, but it can be deployed locally or on a private server (such as A2 or AWS Elastic Beanstalk).


## External Services, 3rd Part Libraries with Licenses:
* Spring Boot:
  * Licenses:
      * [Spring Boot](https://pivotal.io/legal)
  * Dependencies:
```
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>  
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-hateoas</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
```

* Swagger:
  * Licenses:
    * [Swagger](https://swagger.io/license/)
    * [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)
    * [Creative Commons Attribution 2.5](https://creativecommons.org/licenses/by/2.5/)
  * Dependencies:
``` 
    <dependency>
      <groupId>io.swagger</groupId>
      <artifactId>swagger-annotations</artifactId>
      <version>1.5.18</version>
    </dependency>
```

* Apache Derby:
  * Licenses: 
    * [Apache Derby](https://db.apache.org/derby/manuals/index.html)
    * [Apache License 2.0](http://www.apache.org/licenses/)
  * Dependencies:
```
    <dependency>
      <groupId>org.apache.derby</groupId>
      <artifactId>derby</artifactId>
      <scope>runtime</scope>
    </dependency>
```

## Build and User Instructions:
* Clone the repository in IntelliJ idea.
* Update application.properties to use the correct server.port number (be sure the port isn't being used by anything else).
* Run the application.
* Now the database is running, initialize the grid portion of the backend by:
* * First, call a post operation on /squares
* * Second, call a post operation on /vertices
* At this point full interaction with the database, using the defined end points, can take place.
