 <link rel="stylesheet" href="./src/main/resources/static/assets/styles.css">
 <div class="logo-container">
    <img src="./src/main/resources/static/assets/logo.png" alt="Drones" width=200px class="logo" />
  </div>

# Drone Management System

![GitHub last commit (branch)](https://img.shields.io/github/last-commit/exagonsoft/drones-management-board-backend/main?style=flat&logo=github&logoColor=blue)
![Codecov](https://img.shields.io/codecov/c/github/exagonsoft/drones-management-board-backend?style=flat&logo=codecov&logoColor=red)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/3e408694278844d7abd9213edc405d0b)](https://app.codacy.com/gh/exagonsoft/drones-management-board-backend/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
![GitHub](https://img.shields.io/github/license/exagonsoft/ShieldBearer?style=flat&logo=Medium&logoColor=green)

**Description:**
-

The *Drone Management System* is a comprehensive solution developed for efficient management and monitoring of drones. This project is a part of the Technical Test solution for Musala Soft. The system aims to optimize drone operations, enhance safety, and improve overall productivity in various sectors, such as logistics, healthcare, and surveillance. The system provides a user-friendly interface for managing a fleet of drones, monitoring their status, and ensuring seamless communication between drones and ground control.


**Key Features:**
-

1. **Drone Fleet Management:**
   - Register new drones in the system, including details like serial number, model, weight capacity, and battery capacity.
   - Categorize drones based on their types and models for streamlined organization.

2. **Real-time Monitoring:**
   - Track drones in real-time on a map interface, allowing users to monitor their locations and activities.
   - View battery levels, current status, and mission progress for each drone.

3. **Medication Delivery Management:**
   - Enable drone load and unload functionality for transporting medications and medical supplies.
   - Manage medication inventory and assign specific medications to drones for delivery.

4. **Automated Audit Logs:**
   - Generate audit logs for every drone activity, providing a detailed history of operations.
   - Monitor drone usage, status changes, and battery levels through comprehensive audit trails.

5. **Automated Lifecycle Simulation:**
   - Simulate drone lifecycle events, including state transitions and battery level changes.
   - Automate state changes based on predefined conditions, ensuring efficient use of drones.

6. **Exception Handling and Notifications:**
   - Implement error handling mechanisms for scenarios like low battery, invalid payloads, or system failures.
   - Send notifications to administrators and operators for critical events, enabling rapid response.


**Technologies Used:**
-
- **Backend:** Java, Spring Boot, Spring Data JPA
- **Frontend:** React.js
- **Database:** H2 inMemory
- **Testing:** JUnit, Mockito for unit testing
- **Deployment:** Docker, Docker Compose for containerization and orchestration


**Installation:**
-

1. Clone the repository:
   ```batch
   git clone https://oauth:glpat-2r4Q5zpjfpstAZCfPrFy@gitlab.com/musala_soft/DEV_DRONES-99f4509e-7173-5ebe-4dc3-c5240317ba68.git

   cd <project-folder>
   ```



**Run Instructions:**
-

1. Build the project using Maven:
   ```batch
   mvn clean install
   ```
2. Run the Spring Boot application using Maven:
   ```batch
   mvn spring-boot:run
   ```
3. Access the application in your web browser at `http://localhost:8080`.

**Test Instructions:**
-

1. Run unit tests using Maven:
   ```batch
   mvn test
   ```
2. Verify the test results to ensure all functionalities are working as expected.

**Run Instructions Using Docker:**
-

1. Start the Docker Process:
   ```batch
   docker compose up -d
   ```
2. Access the application in your web browser at `http://localhost:8080`.

**Test Instructions Using Docker:**
-

1. Run unit tests using Maven:
   ```batch
   mvn test
   ```
2. Verify the test results to ensure all functionalities are working as expected.


**Usage**
-
*Consume endpoints using tools like:*
  - PostMan
  - Imsomnia

***ENDPOINTS***
  - Register a new Drone
    - URL: (POST) http://localhost:8080/api/drones
    - Payload: (Json Body .ex)
      ```Json
      {
        "serial_number": "rfwe3245",
        "payload": "Lightweight",
        "max_weight": 500,
        "battery_capacity": 100,
        "state": "IDLE"
      }
      ```
    - annotations:
      - serial_number: (100 characters max)
      - model (Lightweight, Middleweight, Cruiserweight, Heavyweight)
      - weight limit (500gr max)
      - battery capacity (100 max)
      - state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING)
  - Load Medications to a Drone
    - URL: (PUT) http://localhost:8080/api/drones/medications/load/{droneId}
    - Payload: (Json Body .ex)
      ```Json
      {
        "medicationsListIds": [1, 2, 3, 4, 5]
      }
      ```
  - Check Drone Medications Carried
    - URL: (GET) http://localhost:8080/api/drones/medications/{dronrId}
  - Check Drones Available for Load
    - URL: (GET) http://localhost:8080/api/drones/available
  - Check Drone Battery Level
    - URL: (GET) http://localhost:8080/api/drones/check_battery/{droneId}

***ADDITIONAL END POINTS***
   - Drone End Points
     - Update Existing Drone
       - URL: (PUT) http://localhost:8080/api/drones/{droneId}
       - Payload: (Json Body .ex)
         ```Json
         {
           "serial_number": "rfwe3245",
           "payload": "Lightweight",
           "max_weight": 500,
           "battery_capacity": 100,
           "state": "IDLE"
         }
         ```
       - annotations:
         - serial_number: Wont be Changed
         - model (Lightweight, Middleweight, Cruiserweight, Heavyweight)
         - weight limit (500gr max)
         - battery capacity (100 max)
         - state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING)
     - Get Drone Details
       - URL: (GET) http://localhost:8080/api/drones/{droneId}
     - List All Drones
       - URL: (GET) http://localhost:8080/api/drones/
   - Medication End Points
     - Register Medication
       - URL: (POST) http://localhost:8080/api/medications
       - Payload: (Json Body .ex)
         ```Json
         {
	       "name": "Apparatus_63",
           "weight": 22,
           "code": "APP_63_HIJKLMNOP",
           "imageUrl": "localhost:5173/uploads/Apparatus_63.png"
         }
         ```
       - annotations:
         - name (allowed only letters, numbers, ‘-‘, ‘_’)
         - code (allowed only upper case letters, underscore and numbers);
     - Edit Existing Medication
       - URL: (PUT) http://localhost:8080/api/medications/{medicationId}
       - Payload: (Json Body .ex)
         ```Json
         {
	       "name": "Apparatus_63",
           "weight": 22,
           "code": "APP_63_HIJKLMNOP",
           "imageUrl": "localhost:5173/uploads/Apparatus_63.png"
         }
         ```
       - annotations:
         - name (allowed only letters, numbers, ‘-‘, ‘_’)
         - code (allowed only upper case letters, underscore and numbers);
       - List All Medications
         - URL: (GET) http://localhost:8080/api/medications
       - Get Medication Details
         - URL: (GET) http://localhost:8080/api/medications/{medicationId}
   - Audit Log End Points
       - List Complete History Logs List
         - URL: (GET) http://localhost:8080/api/audit_logs
       - List Drone History Logs
         - URL: (GET) http://localhost:8080/api/audit_logs/{droneId}

<br />
<br />

# App Life Cycle
  - The App starts with 4 Drones in Existence
  - The App starts with 6 Medications in Existence
  - Every 3 minutes the app will register te battery level for all the Drones on an Audit Log  Structure
  - After Loading a Drone it state will change (IDLE - Loading)
  - The App will simulate the Drones Life Cycle by checking every 2 minutes and half and update the Drone State and Battery Capacity accordingly
  - Finally all the operations throw the web has restrictions that the App will handle properly

<br />
<br />

**Purpose:**

The *Drone Management System* is designed to enhance the efficiency and reliability of drone operations in various industries. By providing real-time monitoring, automated simulations, and detailed audit logs, the system ensures that drones are utilized effectively while adhering to safety standards. The project showcases Musala Soft's expertise in developing advanced, scalable solutions for modern challenges in the field of drone technology.