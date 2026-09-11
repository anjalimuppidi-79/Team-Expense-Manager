Yes. Your LeetCode profile link is based on your LeetCode username.

How to find it
Open LeetCode and log in.
Click your profile picture in the top-right.
Click Profile / your username.
Your profile URL will look like:

https://leetcode.com/u/YourUsername/

For example, if your username is anjali123, your link would be:

https://leetcode.com/u/anjali123/

LeetCode's current profile format uses /u/username.

For your resume

You can write:

LeetCode: https://leetcode.com/u/YourUsername/

If you send me your LeetCode username, I can also tell you exactly what your profile link should be.

where

You’re on the right page, but this is the Settings → Profile page. The Display Name (Muppidi_07) is not necessarily the username used in your profile URL.

Do this:

Click your profile picture in the top-right (the blue/white circle).
Select Profile.
Your public profile page will open.
Look at the browser address bar. It should be something like:
https://leetcode.com/u/Muppidi_07/

If clicking the profile picture doesn't show Profile, tell me what options appear in that menu, and I'll guide you exactly.

Expense Tracker Spring Boot REST API(1).docx
Document
for this project    i need readme file to upload in git 

Yes. I created a GitHub-ready README.md for your Team Expense Manager Spring Boot REST API, based on the project document you provided. It includes the tech stack, architecture, database relationships, project structure, API endpoints, sample requests, validation, exception handling, testing flow, and future enhancements.

Download the README

Download README.md

Upload it to GitHub

Put README.md in the root folder of your project:

TeamExpenseManager/
│
├── src/
├── pom.xml
├── README.md
└── .gitignore

Then:

git add README.md
git commit -m "Add project README"
git push

One important correction: before pushing, make sure your application.properties does not contain your real MySQL password. The README I created uses YOUR_MYSQL_PASSWORD instead. Your project document currently shows a sample password configuration.

For your Java Full Stack fresher resume, this README is also useful because it clearly presents the project as a proper Spring Boot REST API, rather than just a basic CRUD project. 

README.md
Document
Ad
Ads do not influence the answers you get from ChatGPT. Your chats stay private. 
Learn about ads and personalization

Sponsored options
Ad
Library
/
README.md
Team Expense Manager

A Spring Boot REST API for managing users, events, event members, and expenses. The application models real-world team trips or events where multiple users can participate in an event and multiple expenses can be recorded against that event.

Features
Create, retrieve, and delete users
Create and retrieve events
Add and remove members from events
Create, retrieve, update, and delete expenses
Retrieve expenses for a specific event
Track which user paid each expense
Calculate event expenses from the recorded expense data
Bean Validation for request data
Duplicate email validation
Centralized REST exception handling
Proper 400 Bad Request, 404 Not Found, and 500 Internal Server Error responses
JPA entity relationships using @ManyToMany, @OneToMany, and @ManyToOne
Automatic many-to-many mapping through the event_members table
Tech Stack
Java 21
Spring Boot 3.5.4
Spring Web
Spring Data JPA
MySQL
Maven
Jakarta Bean Validation
Lombok
Spring Boot DevTools
Architecture

The project follows a layered architecture:

Client / Postman
       |
       v
  Controller
       |
       v
    Service
       |
       v
  Repository
       |
       v
     MySQL

Exception handling is centralized using @RestControllerAdvice.

Project Structure
TeamExpenseManager/
├── src/main/java/com/example/teamexpense
│   ├── controller
│   │   ├── UserController.java
│   │   ├── EventController.java
│   │   └── ExpenseController.java
│   │
│   ├── entity
│   │   ├── User.java
│   │   ├── Event.java
│   │   └── Expense.java
│   │
│   ├── repository
│   │   ├── UserRepository.java
│   │   ├── EventRepository.java
│   │   └── ExpenseRepository.java
│   │
│   ├── dto
│   │   ├── UserRequest.java
│   │   ├── EventRequest.java
│   │   └── ExpenseRequest.java
│   │
│   ├── service
│   │   ├── UserService.java
│   │   ├── EventService.java
│   │   └── ExpenseService.java
│   │
│   └── exception
│       ├── ResourceNotFoundException.java
│       ├── BadRequestException.java
│       ├── ErrorResponse.java
│       └── GlobalExceptionHandler.java
│
└── src/main/resources
    └── application.properties
Database Design

The application uses four tables:

users
events
expenses
event_members
Relationships
User  <---- Many-to-Many ---->  Event
                                  |
                                  |
                             One-to-Many
                                  |
                                  v
                               Expense
                                  |
                                  |
                             Many-to-One
                                  |
                                  v
                                User

The User and Event many-to-many relationship is maintained through:

event_members
----------------
user_id
event_id

An expense belongs to one event and records the user who paid it.

Database Setup

Create the MySQL database:

CREATE DATABASE team_expense_db;

Update src/main/resources/application.properties with your own MySQL credentials:

spring.application.name=TeamExpenseManager

spring.datasource.url=jdbc:mysql://localhost:3306/team_expense_db
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080

Do not commit real database passwords or other secrets to GitHub.

How to Run
1. Clone the repository
git clone <YOUR_GITHUB_REPOSITORY_URL>
cd TeamExpenseManager
2. Create the database
CREATE DATABASE team_expense_db;
3. Configure MySQL

Set your MySQL username and password in application.properties.

4. Run the application

Using Maven:

mvn spring-boot:run

Or run TeamExpenseManagerApplication.java from your IDE.

The application runs on:

http://localhost:8080
REST API Endpoints
User APIs
Method	Endpoint	Description
POST	/api/users	Create user
GET	/api/users	Get all users
GET	/api/users/{id}	Get user by ID
DELETE	/api/users/{id}	Delete user
Event APIs
Method	Endpoint	Description
POST	/api/events	Create event
GET	/api/events	Get all events
GET	/api/events/{id}	Get event by ID
POST	/api/events/{eventId}/members/{userId}	Add member to event
DELETE	/api/events/{eventId}/members/{userId}	Remove member from event
Expense APIs
Method	Endpoint	Description
POST	/api/expenses	Create expense
GET	/api/expenses	Get all expenses
GET	/api/expenses/{id}	Get expense by ID
GET	/api/expenses/event/{eventId}	Get expenses for an event
PUT	/api/expenses/{id}	Update expense
DELETE	/api/expenses/{id}	Delete expense
Sample API Requests
Create User
POST http://localhost:8080/api/users
Content-Type: application/json
{
  "name": "Advith",
  "email": "Advith@gmail.com"
}
Create Event
POST http://localhost:8080/api/events
Content-Type: application/json
{
  "eventName": "Goa Team Trip",
  "location": "Goa"
}
Add Member
POST http://localhost:8080/api/events/1/members/1
Create Expense
POST http://localhost:8080/api/expenses
Content-Type: application/json
{
  "description": "Hotel Booking",
  "amount": 12000,
  "category": "Hotel",
  "expenseDate": "2026-09-06",
  "eventId": 1,
  "userId": 1
}
Get Event Expenses
GET http://localhost:8080/api/expenses/event/1
Validation and Exception Handling

The project uses Jakarta Validation annotations such as:

@NotBlank
@NotNull
@Email
@Positive

For example, an invalid user request can return validation errors instead of accepting invalid data.

Custom exceptions include:

ResourceNotFoundException
BadRequestException

GlobalExceptionHandler uses @RestControllerAdvice to provide centralized exception handling.

Example 404 Not Found response:

{
  "timestamp": "2026-09-06T22:35:20",
  "status": 404,
  "error": "Not Found",
  "message": "User with ID 999 not found",
  "path": "/api/users/999"
}
Testing Flow

A typical testing flow using Postman is:

1. Create Users
       ↓
2. Create Event
       ↓
3. Add Users to Event
       ↓
4. Add Expenses
       ↓
5. Retrieve Event Expenses
       ↓
6. Update/Delete Expenses
       ↓
7. Test Validation and Error Responses

Example event:

Goa Team Trip

Members:
- Advith
- Vihan
- Kiran

Expenses:
- Hotel       ₹12,000
- Food        ₹5,000
- Transport   ₹3,000

Total: ₹20,000
Key Spring Boot Concepts Demonstrated

This project demonstrates:

RESTful API development
Layered architecture
Dependency Injection
Spring Web
Spring Data JPA
Entity mapping
@ManyToMany
@OneToMany
@ManyToOne
@JoinTable
mappedBy
DTOs
Bean Validation
Custom exceptions
Global exception handling
MySQL database integration
Repository abstraction
CRUD operations
Future Enhancements

Possible next improvements include:

Response DTOs and entity-to-DTO mapping
Custom JPQL/native queries
Pagination and sorting
Swagger/OpenAPI documentation
Spring Security
JWT authentication
Frontend integration

Author
Muppidi Anjali

Java Full Stack Developer | Spring Boot | REST APIs | MySQL

If you found this project useful, feel free to explore the source code and API implementation.
