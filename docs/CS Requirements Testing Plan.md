**Project Name:** CleanSweep
**Version:** 1.0  
**Date:** 2026-05-02
**Purpose:** This document outlines test scenarios for the CleanSweep service marketplace system.

## Actors
- Customer C: End user who books cleaning services, manages profile, and writes reviews  
- Provider P: Cleaning service provider who offers services  
- Service S: Cleaning service listing (e.g., home cleaning, deep cleaning, office cleaning)

## 1. Customer: US-CUST-001 — Register & manage profile
1. Customer C1 registers a new account using signup page.
2. C1 logs in with email and password.
3. C1 updates profile information (name, phone, address).

---

## 2. Customer: US-CUST-002 — Browse services
1. Customer C1 logs in.
2. C1 navigates to "/providers".
3. C1 searches services using keyword filter.
4. C1 filters services using maximum price.
---

## 3. Customer: US-CUST-003 — Create booking
1. Customer C2 selects a service S1.
2. C2 enters start date, end date, and address.
3. C2 submits booking request.
4. System generates booking confirmation.

---

## 4. Customer: US-CUST-004 — Cancel booking
1. Customer C2 navigates to "My Bookings".
2. C2 selects an active booking.
3. C2 cancels booking.
4. System updates booking status to CANCELLED.
---

## 5. Customer: US-CUST-005 — Write review
1. Customer C2 completes a booking.
2. C2 opens review form.
3. C2 selects rating (1–5) and writes comment.
4. C2 submits review.


---

## 6. Customer: US-CUST-006 — View reviews
1. Customer C1 opens service details page.
2. C1 scrolls to review section.
3. C1 views all reviews for service S1.

---

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

### Performance Requirements

### Scenario P1: Service listing load time < 1.5s
- **Setup:** System contains multiple services  
- **Steps:**
  1. Load "/providers"
  2. Repeat 10 times  
- **Expected Outcome:** 95% of requests load under 1.5 seconds

### Scenario P2: Booking response time < 2 seconds**

- **Steps:**
  1. Submit booking form
  2. Measure response time
- **Expected Outcome:** Booking confirmation loads in ≤ 2 seconds

---

---
### Security & Privacy Requirements

**Scenario S1:  Authentication required for protected pages**

- **Setup:** User is logged out
- **Steps:**
  1. Try accessing "/my-bookings" without login
- **Expected Outcome:**
  - Redirect to "/login"
  - No data exposed

---

**Scenario S2: User data isolation**

- **Setup:** Customer A is logged in
- **Steps:**
  1. Attempt to access another user's booking via URL
- **Expected Outcome:**
  - Access is denied or redirected
  - No unauthorized modification allowed

---

### Usability Requirements

**Scenario U1: Complete booking flow ≤ 3 minutes**

- **Setup:** New customer account created
- **Steps:**
  1. Login
  2. Browse services
  3. Create booking
- **Expected Outcome:** User completes process within 3 minutes

---
**Scenario U2: Review submission usability**

- **Setup:** Customer has completed booking
- **Steps:**
  1. Open review form
  2. Submit rating and comment
- **Expected Outcome:**
  - Form validates input
  - Review is successfully saved