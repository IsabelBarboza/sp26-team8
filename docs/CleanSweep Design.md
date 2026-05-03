
# CleanSweep -Software Design 

Version 1
Prepared by Team 8
CleanSweep\
March 2, 2026

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Product Overview](#1-product-overview)
* 2 [Actors](#2-actors)
* 3 [Use Case Model](#3-use-case-model)
* 4 [Use Case Descriptions](#4-use-case-descriptions)
  * 4.1 [Customer Use Cases](#41-customer-use-cases)
* 5 [UML Class Model](#5-uml-class-model)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|Barboza|May 2026| Final Design      |    1      |
|      |         |                     |           |
|      |         |                     |           |

## 1. Product Overview
CleanSweep is a web-based application that connects customers with cleaning services.  
Users can browse available services, create bookings, manage their appointments, and submit reviews based on their experience.

The system is designed to be simple, efficient, and user-friendly, focusing on customer-side functionality and persistent data storage.

---

## 2. Actors 

- **Customer** – registers, logs in, browses services, creates bookings, manages bookings, and writes reviews.
- **Provider** – 
- **System Administrator** – 
Note: Provider and Admin roles were not implemented due to reduced project scope.


---

## 3. Use Case Model
![Use Case Model](docs/UseCases.png)

## 4. Use Case Descriptions

### 4.1 Customer Use Cases

#### UC‑CUST‑001 — Register & Manage Customer Profile
**Primary Actor:** Customer  
**Goal:** Create an account and manage personal profile.  
**Stakeholders & Interests:**  
- *Customer:* quick, secure signup; control over personal data.  
- *System:* valid accounts; basic profile completeness for discovery.

**Preconditions:** Customer is not authenticated.

**Trigger:** Selects **Sign up**

**Main Success Scenario:**
1. System displays registration form.  
2. Customer enters required details (name, email, password, etc.).  
3. System validates input.  
4. System creates account .  
5. Customer logs in.  
6. Customer can update profile information.  

**Extensions:**  
- 2a. Password too short → System shows validation message .  
- 3a. Email already exists → System suggests sign‑in or show error.  

**Postconditions (Success):**  Customer account is created and stored.  
**Minimal Guarantees:** No partial or invalid data persisted on failure.  
**Special Requirements:** Usable, accessible form; password policy; (optional) email verification per SRS.  

---------

#### UC‑CUST‑002 — Login
**Primary Actor:** Customer  
**Goal:** Access the system.  
**Stakeholders & Interests:**  
- *Customer:* quick, secure login and validation.  
- *System:* valid accounts; login successful.

**Preconditions:** Account exists .

**Trigger:** Selects **Login**

**Main Success Scenario:**
1. System displays login form.  
2. User enters email and password  .  
3. System validates credentials .  
4. System creates session   .  
5.  User is redirected to home page  
  

**Extensions:**  
- 2a. Account not found → error message .  
- 3a. Incorrect password → error message    

**Postconditions (Success):**  User is authenticated.  
**Minimal Guarantees:** No partial or invalid data persisted on failure.  
**Special Requirements:** Usable, accessible form; password policy; (optional) email verification per SRS.  
---

#### UC‑CUST‑003 — Browse Farm Profiles
**Primary Actor:** Customer  
**Goal:** View available services   
**Preconditions:** None (public browse allowed).  
**Trigger:** Customer chooses **Search servvices**.  
**Main Success Scenario:**
1. System displays all cleaning services   
2. User searches or filters services   
3. System updates results   
4. User selects a service    

**Extensions:**   
- 1a. No farms available → System shows an empty state with guidance.  

**Postconditions:** None (view‑only).

**Special Requirements:** Mobile‑friendly cards; fast loading.  

---

#### UC‑CUST‑004 — Create Booking
**Primary Actor:** Customer  
**Goal:** Book a cleaning service  
**Preconditions:** User is logged in.  
**Trigger:** User selects a service and clicks **Book**   
**Main Success Scenario:**
1. System shows booking form   
2. User enters date, time, and address    
3. System validates data   
4. System creates booking   
5. System redirects to confirmation page with total price and details.    

**Extensions:**   
- 2a. Invalid data → error message.  

**Postconditions:** Booking is stored in database .  
**Special Requirements:**  Transparent pricing / resilient to empty results.  

---

#### UC‑CUST‑005 — View & Manage Bookings
**Primary Actor:** Customer  
**Goal:** View and cancel bookings.    
**Preconditions:** User is logged in.   
**Trigger:** User opens **My Bookings**.  
**Main Success Scenario:**
1. System displays all bookings.  
2. User views booking details.   
3. User cancels booking.    
4. System updates status.  

**Extensions:**   
- 3a. Selected cadence unavailable → System suggests alternatives/dates.  

**Postconditions:** Booking status updated.  
**Special Requirements:** Cancellation allow.  

---

#### UC‑CUST‑005 — Write a Review for a Booking
**Primary Actor:** Customer  
**Goal:** Rate and review a booking.  
**Preconditions:** User has a completed booking
**Trigger:** From bookings lists, user selects **Write Review**.  
**Main Success Scenario:**
1. System shows review form (rating + comments).  
2. User enters rating and comment.  
3. System validates input.  
4. System saves review.  
5. Review is displayed on page.   

**Extensions:**   
- 3a. Missing fields → error message .  

**Postconditions:** Review stored and visible.    
**Special Requirements:** Abuse/fraud controls.  

---


## 5 UML Class Model
![UML Class Model](docs/UML2.png)

Basic relationships in the system:

- Customer → Booking (One-to-Many)  
- Customer → Review (One-to-Many)  
- Booking → CleaningService (Many-to-One)  
- Review → Booking (One-to-One logical relationship) 