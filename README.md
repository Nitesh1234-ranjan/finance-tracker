# Finance Tracker

Finance Tracker is a full-stack personal finance management application built with Spring Boot, Angular, and MySQL.  
It allows users to track incomes and expenses, generate reports, and view a consolidated dashboard. The project is containerized using Docker and can be deployed on AWS EC2 with Jenkins.

## Features

- User Authentication (Login / Logout)
- Income Management  
  - Add, Edit, and Delete income entries
- Expense Management  
  - Add, Edit, and Delete expense records with categories and descriptions
- Reports Dashboard  
  - View total income, total expenses, and balance summary
  - Monthly report generation by selecting month and year
- Dockerized Deployment  
  - Single Dockerfile for backend and frontend
- Route Protection  
  - Dashboard accessible only after login

## Tech Stack

| Layer           | Technology                     |
|-----------------|---------------------------------|
| Frontend        | Angular (Standalone Components) |
| Backend         | Spring Boot 3.3.2, Java 17      |
| Database        | MySQL                          |
| Build Tool      | Maven 3.9.11                    |
| Deployment      | Docker, AWS EC2, Jenkins       |



## Application Setup Setup

1. Build and run the backend:
    mvn clean install, 
    mvn spring-boot:run

2. Frontend Setup (Angular)
    Install dependencies:  cd frontend
                           npm install

    Run the Angular development server: ng serve

