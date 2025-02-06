## Description:
"Messenger" is a web application for exchanging messages between users, developed as a learning exercise. The project is developed using Java Servlets, JSP and Hibernate for managing user and message data. The application provides registration, authorization, sending and receiving messages, and displaying usage statistics.
## Functionality:
### User Registration:
* Users can register by providing their data.
* User data is stored in the database using Hibernate.
### User Authorization:
* Registered users can log in to the system using their credentials.
* The user's session is stored to maintain the authorization state.
* In case of incorrect credentials, the user receives an error message.
### Messaging:
* Authorized users can send messages to other users by selecting the recipient from the list.
* The message text is stored in the database.
* Users can view the list of received messages.
### Statistics:
The administrator has access to application usage statistics, which include:
* Number of active users (number of active sessions).
* Total number of users in the application.
* Total number of sent messages.
### Security:
* UserSecurity filter: Protects pages that require user authorization.
* AdminSecurity filter: Protects pages that are accessible only to the administrator.
## Technologies:
* Java Servlets
* JSP
* Hibernate
* Maven
* Tomcat
