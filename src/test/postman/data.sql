INSERT INTO DEPARTMENT (id, name) VALUES (1, 'Finance');
INSERT INTO DEPARTMENT (id, name) VALUES(2, 'Marketing');

INSERT INTO EMPLOYEE (id, name, department_id) VALUES (1, 'EmpSalaryOne FinanceDept',1);
INSERT INTO EMPLOYEE (id, name, department_id) VALUES (2, 'EmpSalaryTwo FinanceDept', 1);
INSERT INTO EMPLOYEE (id, name, department_id) VALUES (3, 'EmpSalaryOne MarketingDept', 2);
INSERT INTO EMPLOYEE (id, name, department_id) VALUES (4, 'EmpSalaryTwo MarketingDept', 2);

INSERT INTO SALARY (id, base_salary, employee_id) VALUES (1, 10000, 1);
INSERT INTO SALARY (id, base_salary, employee_id) VALUES (2, 20000, 2);
INSERT INTO SALARY (id, base_salary, employee_id) VALUES (3, 10000, 3);
INSERT INTO SALARY (id, base_salary, employee_id) VALUES (4, 20000, 4);

INSERT INTO SALARY_COMPONENT (id, name, factor, salary_id) VALUES (1, 'bonus', 2, 1);
INSERT INTO SALARY_COMPONENT (id, name, factor, salary_id) VALUES (2, 'double bonus', 4, 1);
INSERT INTO SALARY_COMPONENT (id, name, factor, salary_id) VALUES (3, 'bonus two', 2, 2);
INSERT INTO SALARY_COMPONENT (id, name, factor, salary_id) VALUES (4, 'double bonus two', 4, 2);
