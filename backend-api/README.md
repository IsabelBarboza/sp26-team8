# CleanSweep - Backend API Documentation

**Version:** 1.0
**Last Updated:** March 18, 2026
**Base URL:** `http://localhost:8080/api`

---

## Table of Contents

1. [Overview](#1-overview)
2. [User Roles](#2-user-roles)
3. [UML Class Diagram](#3-uml-class-diagram)
4. [API Endpoints](#4-api-endpoints)
   - [Customer Management](#customer-management)
   - [Provider Management](#provider-management)
   - [Provider Management](#provider-management)
   - [Service Management](#service-management)
   - [Bookings Management](#bookings-management)
   - [Review Management](#review-management)
   - [System Admin Management](#system-admin-management)
   - [Audit Logs](#audit-logs)
5. [Use Case Mapping](#5-use-case-mapping)

---
## 1. Overview
The LocalHarvest Hub Backend API provides a RESTful interface for managing: 

- **User Accounts**: Customer, Provider, and SysAdmin roles
- **Provider Profiles**: Information about provider and their operations
- **Services**: Seasonal produce offerings with pricing and capacity management
- **Bookingss**: Customer bookings to services with various cadences
- **Reviews**: Customer feedback on freshness and delivery experiences
- **Audit Logs**: Administrative tracking of system actions

---
## 2. User Roles
The API supports three primary user roles:

| Role | Description | Primary Responsibilities |
|------|-------------|-------------------------|
| **CUSTOMER** | Consumer of services | Browse provider/service, book, write reviews |
| **PROVIDER** | Provider of services | Create/manage service, view metrics, reply to reviews |
| **SYS_ADMIN** | Platform administrator | Manage access, moderate content, view analytics |

---
## 3. UML Class Diagram
![UML Class Diagram](../docs/uml-class.png)

## 4. API Endpoints
**Note:** Users are created through role-specific endpoints (`/customers`, `/providers`, `/sysadmins`), not through a generic `/users` endpoint. This ensures proper role assignment and role-specific attributes.

### Customer Management
#### Create Customer
**Endpoint:** `POST /customers`
**Use Case:** US-CUST-001 (Register as Customer)
**Description:** Create a new customer account with profile information.

```http
POST /customers
Content-Type: application/json

{
  "email": "jane@example.com",
  "passwordHash": "hashed_password",
  "status": "ACTIVE",
  "role": "CUSTOMER",
  "name": "Jane Doe"
}
```

**Response:**
```json
{
  "userId": 1,
  "email": "jane@example.com",
  "status": "ACTIVE",
  "role": "CUSTOMER",
  "name": "Jane Doe",
  "bookings": [],
  "createdAt": "2026-01-15T10:30:00",
  "updatedAt": "2026-01-15T10:30:00"
}
```

**Status Code:** `201 Created`

---

#### Get All Customers
**Endpoint:** `GET /customers`
**Use Case:** Admin user management
**Description:** Retrieve all customer accounts.

```http
GET /customers
```

**Status Code:** `200 OK`

---

#### Get Customer by ID
**Endpoint:** `GET /customers/{id}`
**Use Case:** Customer profile view
**Description:** Retrieve specific customer by ID.

```http
GET /customers/1
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Get Customer by Email
**Endpoint:** `GET /customers/email/{email}`
**Use Case:** Customer lookup
**Description:** Retrieve customer by email address.

```http
GET /customers/email/jane@example.com HTTP/1.1
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Update Customer
**Endpoint:** `PUT /customers/{id}`
**Use Case:** US-CUST-001 (Update Profile)
**Description:** Update customer profile information.

```http
PUT /customers/1
Content-Type: application/json

{
  "name": "Jane Smith",
  "status": "ACTIVE"
}
```

**Response:** Updated customer object

**Status Code:** `200 OK` or `404 Not Found`

---

#### Delete Customer
**Endpoint:** `DELETE /customers/{id}`
**Use Case:** Account deletion
**Description:** Delete customer account.

```http
DELETE /customers/1
```

**Status Code:** `204 No Content` or `404 Not Found`

---
### Provider/Provider Management

#### Create Provider
**Endpoint:** `POST /providers`
**Use Case:** US-FARM-001 (Register as Provider)
**Description:** Create a new provider account.

```http
POST /providers
Content-Type: application/json

{
  "email": "john@example.com",
  "passwordHash": "hashed_password",
  "status": "ACTIVE",
  "role": "PROVIDER",
  "name": "John Smith"
}
```

**Response:**
```json
{
  "userId": 2,
  "email": "john@example.com",
  "status": "ACTIVE",
  "role": "PROVIDER",
  "name": "John Smith",
  "provider": null,
  "createdAt": "2026-01-15T10:30:00",
  "updatedAt": "2026-01-15T10:30:00"
}
```

**Status Code:** `201 Created`

---

#### Get All Providers
**Endpoint:** `GET /providers`
**Use Case:** Browse providers
**Description:** Retrieve all provider accounts.

```http
GET /providers
```

**Status Code:** `200 OK`

---

#### Get Provider by ID
**Endpoint:** `GET /providers/{id}`
**Use Case:** Provider profile view
**Description:** Retrieve specific provider by ID.

```http
GET /providers/2
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Get Provider by Email
**Endpoint:** `GET /providers/email/{email}`
**Use Case:** Provider lookup
**Description:** Retrieve provider by email address.

```http
GET /providers/email/john@example.com HTTP/1.1
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Update Provider
**Endpoint:** `PUT /providers/{id}`
**Use Case:** US-FARM-001 (Update Profile)
**Description:** Update provider profile information.

```http
PUT /providers/2
Content-Type: application/json

{
  "bio": "Third Generation Provider specializing in organic vegetables. Passionate about sustainable agriculture and community engagement.",
  "status": "ACTIVE"
}
```

**Response:** Updated provider object

**Status Code:** `200 OK` or `404 Not Found`

---

#### Delete Provider
**Endpoint:** `DELETE /providers/{id}`
**Use Case:** Account deletion
**Description:** Delete provider account.

```http
DELETE /providers/2
```

**Status Code:** `204 No Content` or `404 Not Found`

---
### Provider Management

#### Create Provider
**Endpoint:** `POST /provider`
**Use Case:** US-FARM-001 (Create Provider Profile)
**Description:** Create a new provider profile.

```http
POST /provider
Content-Type: application/json

{
  "provider": {
    "userId": 2
  },
  "name": "Green Valley Provider",
  "location": "Chapel Hill, NC 27514",
  "description": "Organic family provider specializing in seasonal produce with sustainable practices."
}
```

**Response:**
```json
{
  "providerId": 5,
  "provider": {
    "userId": 2,
    "email": "john@example.com"
  },
  "name": "Green Valley Provider",
  "location": "Chapel Hill, NC 27514",
  "description": "Organic family provider specializing in seasonal produce with sustainable practices.",
  "Services": [],
  "createdAt": "2026-01-15T10:30:00",
  "updatedAt": "2026-01-15T10:30:00"
}
```

**Status Code:** `201 Created`

---

#### Get All provider
**Endpoint:** `GET /provider`
**Use Case:** US-CUST-002 (Browse Provider Profiles)
**Description:** Retrieve all provider.

```http
GET /provider
```

**Response:**
```json
[
  {
    "providerId": 5,
    "provider": {...},
    "name": "Green Valley Provider",
    "location": "Chapel Hill, NC 27514",
    "description": "...",
    "Services": [...]
  }
]
```

**Status Code:** `200 OK`

---

#### Get Provider by ID
**Endpoint:** `GET /provider/{id}`
**Use Case:** US-CUST-002 (View Provider Details)
**Description:** Retrieve specific provider profile.

```http
GET /provider/5
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Update Provider
**Endpoint:** `PUT /provider/{id}`
**Use Case:** US-FARM-001 (Update Provider Profile)
**Description:** Update provider profile information.

```http
PUT /provider/5
Content-Type: application/json

{
  "description": "Updated provider description...",
  "location": "Chapel Hill, NC 27516"
}
```

**Response:** Updated provider object

**Status Code:** `200 OK` or `404 Not Found`

---

#### Delete Provider
**Endpoint:** `DELETE /provider/{id}`
**Use Case:** Provider removal
**Description:** Delete provider profile.

```http
DELETE /provider/5
```

**Status Code:** `204 No Content` or `404 Not Found`

---

### Service Management

#### Create Service
**Endpoint:** `POST /service`
**Use Case:** US-FARM-002 (Create Service - Service)
**Description:** Create a new service offering.

```http
POST /service
Content-Type: application/json

{
  "provider": {
    "providerId": 5
  },
  "title": "Spring Veggie Box",
  "description": "Fresh spring vegetables including lettuce, spinach, peas...",
  "season": "SPRING",
  "produce": "Lettuce, Spinach, Peas, Carrots, Radishes",
  "price": 35.99,
  "capacity": 50,
  "status": "PUBLISHED",
  "pickupDeliveryNotes": "Thursday pickup or Friday delivery"
}
```

**Response:**
```json
{
  "serviceId": 10,
  "provider": {
    "providerId": 5,
    "name": "Green Valley Provider"
  },
  "title": "Spring Veggie Box",
  "description": "Fresh spring vegetables including lettuce, spinach, peas...",
  "season": "SPRING",
  "produce": "Lettuce, Spinach, Peas, Carrots, Radishes",
  "price": 35.99,
  "capacity": 50,
  "status": "PUBLISHED",
  "cadence": "WEEKLY",
  "pickupDeliveryNotes": "Thursday pickup or Friday delivery",
  "createdAt": "2026-01-15T10:30:00",
  "updatedAt": "2026-01-15T10:30:00"
}
```

**Status Code:** `201 Created`

---

#### Get All services
**Endpoint:** `GET /service`
**Use Case:** US-CUST-003 (Discover services)
**Description:** Retrieve all available services.

```http
GET /service
```

**Query Parameters:**
- `season` (Optional): Filter by season (SPRING, SUMMER, FALL, WINTER)
- `price` (Optional): Filter by maximum price
- `status` (Optional): Filter by status (PUBLISHED, SUSPENDED, PENDING)

**Example with filters:**
```http
GET /service?season=SPRING&price=40
```

**Status Code:** `200 OK`

---

#### Get Service by ID
**Endpoint:** `GET /service/{id}`
**Use Case:** US-CUST-004 (View Service Details)
**Description:** Retrieve specific service with full details.

```http
GET /service/10
```

**Response:** See Create Service endpoint

**Status Code:** `200 OK` or `404 Not Found`

---

#### Get services by Provider ID
**Endpoint:** `GET /service/provider/{providerId}`
**Use Case:** US-CUST-003 (Browse Boxes by Provider)
**Description:** Retrieve all services from a specific provider.

```http
GET /service/provider/5
```

**Response:** Array of services

**Status Code:** `200 OK`

---

#### Get services by Status
**Endpoint:** `GET /service/status/{status}`
**Use Case:** US-FARM-002 (View Box Listings)
**Description:** Retrieve service filtered by status.

```http
GET /service/status/PUBLISHED
```

**Response:** Array of services with matching status

**Status Code:** `200 OK`

---

#### Update Service
**Endpoint:** `PUT /service/{id}`
**Use Case:** US-FARM-003 (Update Harvest Schedule), US-FARM-004 (Edit/Suspend Box)
**Description:** Update service information, including capacity and status.

```http
PUT /service/10
Content-Type: application/json

{
  "capacity": 40,
  "status": "SUSPENDED",
  "updatedAt": "2026-01-15T10:30:00"
}
```

**Response:** Updated service object

**Status Code:** `200 OK` or `404 Not Found`

---

#### Delete Service
**Endpoint:** `DELETE /service/{id}`
**Use Case:** Box removal
**Description:** Delete a service listing.

```http
DELETE /service/10 HTTP/1.1
```

**Status Code:** `204 No Content` or `404 Not Found`

---
### Booking Management

#### Create Booking
**Endpoint:** `POST /bookings`
**Use Case:** US-CUST-005 (book to Service)
**Description:** Create a new booking to a service.

```http
POST /bookings
Content-Type: application/json

{
  "customer": {
    "userId": 1
  },
  "Services": {
    "serviceId": 10
  },
  "cadence": "WEEKLY",
  "startDate": "2026-01-20",
  "status": "ACTIVE"
}
```

**Response:**
```json
{
  "bookingId": 101,
  "customer": {
    "userId": 1,
    "email": "jane@example.com"
  },
  "Services": {
    "serviceId": 10,
    "title": "Spring Veggie Box"
  },
  "cadence": "WEEKLY",
  "startDate": "2026-01-20",
  "endDate": null,
  "status": "ACTIVE",
  "createdAt": "2026-01-15T10:30:00",
  "updatedAt": "2026-01-15T10:30:00"
}
```

**Status Code:** `201 Created`

---

#### Get All bookings
**Endpoint:** `GET /bookings`
**Use Case:** Admin booking management
**Description:** Retrieve all bookings.

```http
GET /bookings
```

**Status Code:** `200 OK`

---

#### Get Booking by ID
**Endpoint:** `GET /bookings/{id}`
**Use Case:** Booking detail view
**Description:** Retrieve specific booking.

```http
GET /bookings/101
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Get bookings by Customer ID
**Endpoint:** `GET /bookings/customer/{customerId}`
**Use Case:** US-CUST-001 (Manage Customer bookings)
**Description:** Retrieve all bookings for a specific customer.

```http
GET /bookings/customer/1
```

**Response:** Array of customer bookings

**Status Code:** `200 OK`

---

#### Get bookings by Service ID
**Endpoint:** `GET /bookings/service/{serviceId}`
**Use Case:** US-FARM-006 (View Customer Engagement Metrics)
**Description:** Retrieve all bookings to a specific service.

```http
GET /bookings/service/10
```

**Response:** Array of bookings to the service

**Status Code:** `200 OK`

---

#### Get bookings by Status
**Endpoint:** `GET /bookings/status/{status}`
**Use Case:** Booking status filtering
**Description:** Retrieve bookings filtered by status.

```http
GET /bookings/status/ACTIVE
```

**Response:** Array of bookings with matching status

**Status Code:** `200 OK`

---

#### Update Booking
**Endpoint:** `PUT /bookings/{id}`
**Use Case:** US-CUST-006 (Manage Booking - Pause/Skip/Change/Cancel)
**Description:** Update booking cadence, status, or end date.

```http
PUT /bookings/101
Content-Type: application/json

{
  "cadence": "BIWEEKLY",
  "status": "PAUSED",
  "endDate": null
}
```

**Common Status Updates:**

**Pause Booking:**
```json
{
  "status": "PAUSED"
}
```

**Cancel Booking:**
```json
{
  "status": "CANCELLED",
  "endDate": "2026-02-15"
}
```

**Change Cadence:**
```json
{
  "cadence": "MONTHLY"
}
```

**Response:** Updated booking object

**Status Code:** `200 OK` or `404 Not Found`

---

#### Delete Booking
**Endpoint:** `DELETE /bookings/{id}`
**Use Case:** Booking removal
**Description:** Delete a booking (hard delete).

```http
DELETE /bookings/101
```

**Status Code:** `204 No Content` or `404 Not Found`

---
### Review Management

#### Create Review
**Endpoint:** `POST /reviews`
**Use Case:** US-CUST-007 (Write a Review)
**Description:** Create a new review for a completed booking.

```http
POST /reviews
Content-Type: application/json

{
  "booking": {
    "bookingId": 101
  },
  "cleanlinessRating": 5,
  "punctualityRating  ": 4,
  "qualityRating": 5,
  "comment": "Great quality produce and reliable delivery! The vegetables were fresh and the timing was perfect."
}
```

**Response:**
```json
{
  "reviewId": 201,
  "booking": {
    "bookingId": 101
  },
  "cleanlinessRating": 5,
  "punctualityRating  ": 4,
  "qualityRating": 5,
  "comment": "Great quality produce and reliable delivery! The vegetables were fresh and the timing was perfect.",
  "replyText": null,
  "createdAt": "2026-01-25T10:30:00",
  "updatedAt": "2026-01-25T10:30:00"
}
```

**Validation Rules:**
- `cleanlinessRating`, `punctualityRating  `, `qualityRating`: Must be between 1 and 5
- Review can only be created within 14-30 days of booking completion
- Each booking can have only one review

**Status Code:** `201 Created`

---

#### Get All Reviews
**Endpoint:** `GET /reviews`
**Use Case:** US-CUST-008 (Read Reviews)
**Description:** Retrieve all reviews in the system.

```http
GET /reviews
```

**Status Code:** `200 OK`

---

#### Get Review by ID
**Endpoint:** `GET /reviews/{id}`
**Use Case:** Review detail view
**Description:** Retrieve specific review.

```http
GET /reviews/201
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Get Reviews by Booking ID
**Endpoint:** `GET /reviews/booking/{bookingId}`
**Use Case:** US-CUST-008 (Read Reviews for Booking)
**Description:** Retrieve all reviews for a specific booking.

```http
GET /reviews/booking/101
```

**Response:** Array of reviews for the booking

**Status Code:** `200 OK`

---

#### Update Review
**Endpoint:** `PUT /reviews/{id}`
**Use Case:** US-FARM-007 (Reply to Reviews)
**Description:** Update review (provider reply or re-scoring).

```http
PUT /reviews/201
Content-Type: application/json

{
  "cleanlinessRating": 5,
  "punctualityRating  ": 4,
  "qualityRating": 5,
  "comment": "Updated comment...",
  "replyText": "Thank you for the wonderful review! We're glad you enjoyed the fresh vegetables."
}
```

**Response:** Updated review object

**Status Code:** `200 OK` or `404 Not Found`

---

#### Delete Review
**Endpoint:** `DELETE /reviews/{id}`
**Use Case:** US-ADMIN-003 (Moderate Reviews - Remove)
**Description:** Delete a review (admin moderation).

```http
DELETE /reviews/201
```

**Status Code:** `204 No Content` or `404 Not Found`

---
### System Admin Management

#### Create SysAdmin
**Endpoint:** `POST /sysadmins`
**Use Case:** Admin account creation
**Description:** Create a new system administrator account.

```http
POST /sysadmins
Content-Type: application/json

{
  "email": "admin@example.com",
  "passwordHash": "hashed_password",
  "status": "ACTIVE",
  "role": "SYS_ADMIN",
  "name": "Alice Administrator"
}
```

**Response:**
```json
{
  "userId": 3,
  "email": "admin@example.com",
  "status": "ACTIVE",
  "role": "SYS_ADMIN",
  "name": "Alice Administrator",
  "createdAt": "2026-01-15T10:30:00",
  "updatedAt": "2026-01-15T10:30:00"
}
```

**Status Code:** `201 Created`

---

#### Get All SysAdmins
**Endpoint:** `GET /sysadmins`
**Use Case:** Admin management
**Description:** Retrieve all system administrators.

```http
GET /sysadmins
```

**Status Code:** `200 OK`

---

#### Get SysAdmin by ID
**Endpoint:** `GET /sysadmins/{id}`
**Use Case:** Admin profile view
**Description:** Retrieve specific administrator.

```http
GET /sysadmins/3
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Get SysAdmin by Email
**Endpoint:** `GET /sysadmins/email/{email}`
**Use Case:** Admin lookup
**Description:** Retrieve administrator by email.

```http
GET /sysadmins/email/admin@example.com HTTP/1.1
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Update SysAdmin
**Endpoint:** `PUT /sysadmins/{id}`
**Use Case:** Admin profile management
**Description:** Update administrator information.

```http
PUT /sysadmins/3
Content-Type: application/json

{
  "status": "ACTIVE",
  "name": "Alice A. Administrator"
}
```

**Response:** Updated SysAdmin object

**Status Code:** `200 OK` or `404 Not Found`

---

#### Delete SysAdmin
**Endpoint:** `DELETE /sysadmins/{id}`
**Use Case:** Admin removal
**Description:** Delete administrator account.

```http
DELETE /sysadmins/3
```

**Status Code:** `204 No Content` or `404 Not Found`

---

### Audit Logs

#### Create Audit Log
**Endpoint:** `POST /audit-logs`
**Use Case:** US-ADMIN-001, US-ADMIN-002, US-ADMIN-003 (Log Administrative Actions)
**Description:** Create an audit log entry (typically done automatically by the system).

```http
POST /audit-logs
Content-Type: application/json

{
  "admin": {
    "userId": 3
  },
  "action": "SUSPENDED_USER",
  "entityType": "USER",
  "entityId": 1,
  "reason": "Policy violation",
  "details": "User violated content guidelines. Multiple complaints received."
}
```

**Response:**
```json
{
  "logId": 301,
  "admin": {
    "userId": 3,
    "email": "admin@example.com"
  },
  "action": "SUSPENDED_USER",
  "entityType": "USER",
  "entityId": 1,
  "reason": "Policy violation",
  "details": "User violated content guidelines. Multiple complaints received.",
  "createdAt": "2026-01-25T10:30:00"
}
```

**Common Action Types:**
- `CREATED_USER`: User account created
- `SUSPENDED_USER`: User account suspended
- `BANNED_USER`: User account banned
- `APPROVED_BOX`: Service approved
- `REJECTED_BOX`: Service rejected
- `SUSPENDED_BOX`: Service suspended
- `APPROVED_REVIEW`: Review approved
- `MASKED_REVIEW`: Review masked for PII
- `REMOVED_REVIEW`: Review removed

**Status Code:** `201 Created`

---

#### Get All Audit Logs
**Endpoint:** `GET /audit-logs`
**Use Case:** US-ADMIN-001, US-ADMIN-004 (View Admin Actions and Analytics)
**Description:** Retrieve all audit log entries.

```http
GET /audit-logs
```

**Status Code:** `200 OK`

---

#### Get Audit Log by ID
**Endpoint:** `GET /audit-logs/{id}`
**Use Case:** Log detail view
**Description:** Retrieve specific audit log entry.

```http
GET /audit-logs/301
```

**Status Code:** `200 OK` or `404 Not Found`

---

#### Get Audit Logs by Admin ID
**Endpoint:** `GET /audit-logs/admin/{adminId}`
**Use Case:** US-ADMIN-004 (Track Specific Admin Actions)
**Description:** Retrieve all audit logs created by a specific administrator.

```http
GET /audit-logs/admin/3
```

**Response:** Array of audit logs by the admin

**Status Code:** `200 OK`

---

#### Get Audit Logs by Entity Type
**Endpoint:** `GET /audit-logs/entity-type/{entityType}`
**Use Case:** US-ADMIN-004 (Track Changes by Entity)
**Description:** Retrieve audit logs filtered by entity type.

```http
GET /audit-logs/entity-type/USER
```

**Response:** Array of audit logs for the entity type

**Status Code:** `200 OK`

---

#### Update Audit Log
**Endpoint:** `PUT /audit-logs/{id}`
**Use Case:** Log modification (minimal usage)
**Description:** Update audit log entry.

```http
PUT /audit-logs/301
Content-Type: application/json

{
  "details": "Updated details about the action..."
}
```

**Response:** Updated audit log object

**Status Code:** `200 OK` or `404 Not Found`

---

#### Delete Audit Log
**Endpoint:** `DELETE /audit-logs/{id}`
**Use Case:** Log deletion (restricted, typically only for testing)
**Description:** Delete audit log entry.

```http
DELETE /audit-logs/301
```

**Status Code:** `204 No Content` or `404 Not Found`

---
## 5. Use Case Mapping
The API endpoints are designed to support the following SRS use cases:

### Customer Use Cases

| Use Case | Description | Related Endpoints |
|----------|-------------|-------------------|
| **US-CUST-001** | Register & manage customer profile | `POST /customers`, `PUT /customers/{id}` |
| **US-CUST-002** | Browse provider profiles | `GET /provider`, `GET /provider/{id}` |
| **US-CUST-003** | Discover services (filter & sort) | `GET /service`, `GET /service/provider/{providerId}`, `GET /service/status/{status}` |
| **US-CUST-004** | View service details | `GET /service/{id}` |
| **US-CUST-005** | book to service | `POST /bookings` |
| **US-CUST-006** | Manage booking (pause/skip/change/cancel) | `PUT /bookings/{id}` |
| **US-CUST-007** | Write a review | `POST /reviews` |
| **US-CUST-008** | Read reviews | `GET /reviews`, `GET /reviews/booking/{bookingId}` |

### Provider (Provider) Use Cases

| Use Case | Description | Related Endpoints |
|----------|-------------|-------------------|
| **US-FARM-001** | Register & manage provider profile | `POST /providers`, `PUT /providers/{id}`, `POST /provider`, `PUT /provider/{id}` |
| **US-FARM-002** | Create service offering | `POST /service` |
| **US-FARM-003** | Update harvest schedule & quantities | `PUT /service/{id}` |
| **US-FARM-004** | Edit or suspend service | `PUT /service/{id}` |
| **US-FARM-005** | Manage capacity (sold out) | `PUT /service/{id}` |
| **US-FARM-006** | View customer engagement metrics | `GET /bookings/service/{serviceId}` |
| **US-FARM-007** | Reply to customer reviews | `PUT /reviews/{id}` |

### SysAdmin Use Cases

| Use Case | Description | Related Endpoints |
|----------|-------------|-------------------|
| **US-ADMIN-001** | Manage user access (warn/suspend/ban) | `PUT /customers/{id}`, `PUT /providers/{id}`, `PUT /sysadmins/{id}`, `POST /audit-logs` |
| **US-ADMIN-002** | Moderate product listings | `PUT /service/{id}`, `POST /audit-logs` |
| **US-ADMIN-003** | Moderate reviews (approve/mask/remove) | `DELETE /reviews/{id}`, `PUT /reviews/{id}`, `POST /audit-logs` |
| **US-ADMIN-004** | View platform usage & delivery/pickup success | `GET /audit-logs`, `GET /audit-logs/admin/{adminId}`, `GET /audit-logs/entity-type/{entityType}` |

---
