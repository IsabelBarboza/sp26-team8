# CleanSweep- MVC Application

A Spring MVC web application that allows customers to browse cleaning services, create bookings, manage their profile, and submit reviews. The system focuses on customer-side functionality with persistent database storage.
## Architecture Overview

This application follows the **Model-View-Controller (MVC)** pattern:

### Models (Entities)
Located in `src/main/java/com/sp26/team8/entity/`

- **User** - Base entity for authentication (abstract parent class)
- **Customer** - Extends User; manages bookings and reviews
- **CleaningService** - Represents cleaning services available for booking
- **Booking** - Represents a service booking with status (ACTIVE, CANCELLED, COMPLETED)
- **Review** - Customer feedback linked to a booking

### Views (Templates)
Located in `src/main/resources/templates/`

**Customer Views:**
- `customer/dashboard.ftlh` - Overview with subscriptions and reviews
- `customer/browse-products.ftlh` - Product grid with price/season info
- `customer/product-detail.ftlh` - Detailed product view with subscription form
- `customer/subscriptions-management.ftlh` - Manage active subscriptions
- `customer/my-reviews.ftlh` - Customer's submitted reviews with farmer replies
- `customer/review-form.ftlh` - 5-star review submission form
- `customer/profile-settings.ftlh` - Update customer profile

**Farmer Views:**
- `index.ftlh` - Home dashboard showing booking statistics
- `my-bookings.ftlh` - Displays user bookings with status
- `booking.ftlh` - Booking form for selected service
- `profile.ftlh` - Customer profile page
- `review.ftlh` - Submit and view reviews
- `confirmation.ftlh` - Booking confirmation page
- `providers.ftlh` - Displays available cleaning services

**Public Pages:**
- `login.ftlh` - Authentication page
- `signup.ftlh` - User registration page
- `error.ftlh` - Error page

### Controllers

**API Controllers** - RESTful endpoints for data operations:
- `BookingController` - Handles booking-related operations (create, update status, retrieve bookings)
- `CustomerController` - Customer CRUD operations
- `CleaningServiceController` - Provides endpoints for retrieving and filtering cleaning services
- `ReviewController` - Handles review creation and retrieval

**UI Controllers** - Page rendering and navigation:
- `ViewUIController` - Handles all routes 

### Services
Located in `rc/main/java/com/sp26/team8/service/`

Business logic layer providing CRUD operations and domain-specific functionality:
- `CustomerService` - Customer registration, profile updates, account management
- `CleaningServiceService` - Service browsing and filtering
- `BookingService` - Booking creation, cancellation, and retrieval
- `ReviewService` - Review creation and retrieval


### Repositories
Located in `src/main/java/com/sp26/team8/repository/`

Data access layer interfacing with the database (Spring Data JPA):
- `CustomerRepository` - Customer data access
- `CleaningServiceRepository` - Service queries
- `BookingRepository` - Booking queries
- `ReviewRepository` - Review queries

## Key Features

### User Roles & Authentication
- **Customer**: Browse products, create bookings, leave reviews
- **Farmer**:
- **Admin**:

### Customer Flow
1. User signs up and logs in
2. User browses available cleaning services
3. User selects a service and creates a booking
4. User views bookings in "My Bookings"
5. User cancels booking if needed
6. User submits a review after booking
7. User manages profile information

### Navigation
All pages use a unified FreeMarker macro-based navbar that automatically adjusts based on:
- Session-based login system
- Redirects unauthorized users to /login
- Clean UI using Bootstrap

## Session Management
- Uses `HttpSession` for storing `customerId`
- Automatic redirect to signin for unauthenticated access to protected pages
- Session validation on all sensitive endpoints

## Database Relationships
- **One-to-Many**: Customer → Bookings
- **Many-to-One**: Customer → Reviews
- **One-to-Many**: Booking → CleaningService
- **Many-to-One**: Review → Booking

- **Cascade Operations**: Automatic cascading for related entity changes
- **JsonIgnoreProperties**: Prevents circular reference serialization


------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------

## How to Run the Project (Maven)

### 1. Navigate to the project directory
cd mvc-app

### 2. Build the project
mvn clean install

### 3. Run the application
mvn spring-boot:run

### 4. Open in browser
http://localhost:8080/


---

## Testing

All functional and non-functional requirements are documented in:
/docs/CS Requirements Testing Plan.md

---

## Submission

- GitHub repository link (final merged branch)
- Fully working application
- Updated documentation (README + Testing Plan)

-----

## Notes

- Ensure your database is running before starting the application
- Configure application.properties correctly
- Default port: 8080  
- If port is busy, change it in application.properties

---

## Final Status

- All customer use cases implemented
- Data is stored and retrieved from database
- MVC architecture applied
- Application runs successfully with no major errors