# Requirements – Starter Template

**Project Name:** CleanSweep \
**Team:** Isabel Barboza (customer) \ Tim Hehman (provider)
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-02-03

---

## 1. Overview
**Vision.** CleanSweep is a platform for people who need cleaning services. It helps customers find, compare, and book cleaning services in an easy and fast way.

**Glossary** Terms used in the project
- **Term 1:** Booking : A confirmed request made by a customer for a specific service and time.
- **Term 2:** Profile : A user's personal information stored in the system.
- **Term 3:** Provider : A person or business that offers cleaning services through the platform.

**Primary Users / Roles.**
- **Customer (e.g., Student/Patient/Pet Owner/etc. )** — Requests and manages cleaning services through the platform.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — Offers cleaning services and manages customer requests.
- **SysAdmin (optional)** — 

**Scope (this semester).**
- <capability 1>Create and manage user profiles
- <capability 2>Search for available cleaning services
- <capability 3>Book a cleaning service

**Out of scope (deferred).**
- <deferred 1>Payments
- <deferred 2>Mobile app

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑CUST‑001 — Create a profile**  
  _Story:_ As a customer, I want to create a profile so that providers know my details.  
  _Acceptance:_
  ```gherkin
  Scenario: Customer creates a profile.
    Given the customer is on the profile creation page.
    When the customer enters their personal information.
    Then the system saves the profile successfully.
  ```

- **US‑CUST‑002 — Search cleaning services**  
  _Story:_ As a customer, I want search cleaning services so that I can find one that fits my needs. 
  _Acceptance:_
  ```gherkin
  Scenario: Customer searches for services.
    Given the customer is on the services catalog.
    When the customer  searches for cleaning services.
    Then the system shows a list of available services.
  ```
- **US‑CUST‑003 — Book cleaning sevices**  
  _Story:_ As a customer, I want to book a services so that I can schedule a cleaning. 
  _Acceptance:_
  ```gherkin
  Scenario: Customer books a cleaning service.
    Given the customer is on the booking page.
    When the customer selects a service and confirms the booking.
    Then the system books the cleaning services successfully.
  ```

- **US‑CUST‑004 — Leave a service review**  
  _Story:_ As a customer, I want to leave a review so that I can share my feedback about the service.
  _Acceptance:_
  ```gherkin
  Scenario: Customer leaves a review.
    Given the customer has a completed cleaning service order.
    When the customer submit a review.
    Then the system saves the review after services.
  ```
  

### 2.2 Provider Stories
- **US‑PROV‑001 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑PROV‑002 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

### 2.3 SysAdmin Stories
- **US‑ADMIN‑001 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑ADMIN‑002 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** description 
- **Availability/Reliability:** description
- **Security/Privacy:** description
- **Usability:** description

---

## 4. Assumptions, Constraints, and Policies
- list any rules, policies, assumptions, etc.

---

## 5. Milestones (course‑aligned)
- **M2 Requirements** — this file + stories opened as issues. 
- **M3 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M4 Design** — architecture, schema, API outline. 
- **M5 Backend API** — key endpoints + tests. 
- **M6 Increment** — ≥2 use cases end‑to‑end. 
- **M7 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.
