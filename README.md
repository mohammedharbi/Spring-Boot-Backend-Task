Job Listing REST API

This is a simple backend project built with Spring Boot.
The goal of the project is to create a small Job Listing system with CRUD operations, validation, exception handling, pagination, sorting, and API documentation.

* Technologies Used

-Java 17
- Spring Boot 3.4.0
- Spring Web
- Spring Data JPA
- MySQL
- Validation
- Lombok
- Swagger (OpenAPI)
- JUnit + Mockito

* How to Run the Project
1. Clone the project
git clone https://github.com/your-username/job-listing-api
cd job-listing-api

2. Create the database
CREATE DATABASE joblisting;

3. Configure MySQL in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/joblisting
spring.datasource.username=root

spring.jpa.hibernate.ddl-auto=update

4. Run the project
mvn spring-boot:run

*  API Endpoints
Job Endpoints
Method	Endpoint	Description
GET	/api/v1/Job-listing-system/read-all-jobs	Get all jobs
POST	/api/v1/Job-listing-system/add-job	Add a job
PUT	/api/v1/Job-listing-system/update-job/id/{id}	Update a job
DELETE	/api/v1/Job-listing-system/delete-job/id/{id}	Delete a job
GET	/api/v1/Job-listing-system/jobs-pagination-sort/offSet/{offset}/pageSize/{pageSize}/field/{field}	Pagination & sorting

 
 * Example Job JSON
{
  "title": "Backend Developer",
  "description": "Work on Spring Boot APIs",
  "location": "Riyadh",
  "salary": 12000,
  "employmentType": "FULL_TIME"
}


* Swagger Documentation

After running the app, open:

http://localhost:8090/swagger-ui/index.html


*  What I Implemented:

- CRUD operations for jobs

- Pagination and sorting

- Input validation

- Global exception handling (@ControllerAdvice)

- Logging for requests and errors

- Unit tests for the service and controller

- Clean and organized project structure

** Notes

This project was built as part of a backend task to demonstrate Spring Boot fundamentals like REST API design, database integration, testing, and documentation.
