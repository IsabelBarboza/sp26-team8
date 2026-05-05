
# CleanSweep - MVC Web Application

## Project Overview

CleanSweep is a Spring MVC web application that connects customers with cleaning service providers.  
Users can browse services, create bookings, manage reservations, and leave reviews.

The system follows the MVC (Model-View-Controller) architecture and uses persistent database storage.
---

## Architecture

### MVC Structure

- **Models (Entity Layer):**
  Booking, Customer, Review, User, CleaningService

- **Views (UI Layer):**
  FreeMarker templates (.ftlh files)
  - booking.ftlh
  - login.ftlh
  - signup.ftlh
  - providers.ftlh   (Cleaning Services)
  - my-bookings.ftlh
  - profile.ftlh
  - review.ftlh
  - confirmation.ftlh

- **Controllers:**
  - ViewUIController (handles all UI routes)
  - Booking logic integrated via service layer

---

## Project Structure

mvc-app/
├── src/main/java/com/sp26/team8/
│ ├── controller/
│ ├── entity/
│ ├── service/
| ├── repository/
|    
│
├── src/main/resources/
│ ├── templates/
│ ├── static/
│
├── docs/
│ ├── UML1.png
│ ├── UML2.png
│ ├── UseCases.png
│ ├── CS Requirements Testing Plan.md
| ├── README.md
│ ├── CleanSweepSRS.md
| ├──CleanSweepDesign.md  
├── README.md


---


## How to Run the Project (Maven)

1. Clone repository
git clone https://github.com/IsabelBarboza/sp26-team8/tree/isabel-milestone6

2. Go into project folder
cd sp26-team8/mvc-app

3. Build project
mvn clean install

4. Run application
mvn spring-boot:run

5. Open in browser
http://localhost:8080/

---

## Features

### Customer Features
- User registration and login
- Browse cleaning services
- Filter services by keyword and price
- Create bookings with date and address
- View and cancel bookings
- Submit reviews with rating and comments
- Manage user profile



## Documentation

All documentation is located in the /docs folder:

- UML Class Diagrams (basic and advanced)
- Use Case Diagram
- Requirements Testing Plan
- CleanSweepSRS.md
- CleanSweepDesign.md
- README.md

---

## Final Notes

This project implements all customer-side use cases, ensures persistent data storage, and MVC architecture compliance.