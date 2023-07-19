## employee-department-demo

This app represents relationships between models - it provides statistics on departmental  employee data: Expenses/department; Average salary/department; Employee count/department, etc.

Two teams work are on the app:&nbsp; The backend team is responsible for maintaining microservices; &nbsp; The frontend team develops UIs.

The application aims to able to provide support for

	 - Add / Update / Delete Departments

	 - Add / Update / Delete Employees

	 - Employee salary management

	 - Graphical representation of departmental dashboards:
	 Expenses/department; Average salary/department; Employee count/department, etc.

#### Salary Calculation Logic

SalaryComponent is dependent upon base salary and can be calculated as baseSalary multiplied by respective factor. i.e.

       SalaryComponent_amount = baseSalary * factor;

Actual salary can be calculated as sum of all SalaryComponent amounts.

       Salary_amount = Sum of all SalaryComponent_amounts;


### PRE-REQUISITES
---
Environment setup needed to work on the codebase:
1. Java 17
2. Git
3. Maven
4. Any IDE (IntelliJ / Eclipse / VS Code)


### INSTRUCTIONS
---
*Note:*
All required dependencies (ex. spring boot, data jpa, h2, etc) are already added to the POM.


#### Steps
---
1. Clone app using this CLI command:  git clone https://github.com/inoptradigital/employee-department-demo.git
2. Import the project into your IDE, then build it.
3. Run the spring boot app - fix any exceptions.
4. At this point, the spring boot app should be in a running state, free of exceptions.
5. Open h2 console - http://www.h2database.com/html/quickstart.html - and login (basic h2 properties have been set within the app).

---
**Build**

_mvn clean install_

**Run**
To run the application use
_mvn spring-boot:run_

If things go well, you can check the swagger page at: 
``http://localhost:8080/swagger-ui/index.html``

---
**Test**

_mvn clean test_

----
