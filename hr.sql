SELECT 
MAX(salary),AVG(salary),MIN(salary),MAX(salary)-AVG(salary),AVG(salary)-MIN(salary)
  FROM employees;
  
SELECT count(*)
from employees
where (AVG(salary)-salary )<= 4000;

SELECT COUNT(DISTINCT department_id)
FROM employees;

SELECT AVG(salary)
FROM employees
GROUP BY department_id;

SELECT department_id dept_id, job_id,SUM(salary)
FROM employees
GROUP BY department_id,job_id;

SELECT department_id,MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary)>10000;

SELECT job_id, SUM(salary) PAYROLL
FROM employees
WHERE job_id NOT LIKE '%REP%'
GROUP BY job_id
HAVING SUM(salary) >13000
ORDER BY SUM(salary);

SELECT employees.employee_id,employees.last_name,departments.location_id,department_id
FROM employees JOIN departments
USING (department_id);

SELECT e.employee_id,e.last_name,e.department_id,d.department_id,d.location_id
FROM employees e JOIN departments d
ON (e.department_id = d.department_id);

SELECT e.last_name emp,m.last_name mgr
from employees e JOIN employees m
ON (e.manager_id = m.manager_id);

SELECT e.employee_id,e.last_name,e.department_id,d.department_id,d.location_id
FROM employees e JOIN departments d
ON (e.department_id = d.department_id)
AND e.manager_id = 149;

SELECT employee_id,city,department_name
from employees e
JOIN departments d
ON d.department_id = e.department_id
JOIN locations l
ON d.location_id=l.location_id;

SELECT e.last_name,e.salary,j.grade_level
FROM employees e JOIN job_grades j
ON e.salary
   BETWEEN j.lowest_sal AND j.highest_sal; 
   
SELECT e.last_name,d.department_id,d.department_name
FROM employees e FULL OUTER JOIN departments d
ON (e.department_id = d.department_id);

SELECT last_name,department_name
FROM employees
CROSS JOIN departments;

SELECT last_name, job_id, salary
FROM employees
WHERE salary= 
             (SELECT MIN(salary)
             FROM employees);
             
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ANY
                 (SELECT salary
                 FROM employees
                 WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';

SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ALL
                (SELECT salary
                FROM employees
                WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';

SELECT emp.last_name
FROM employees emp
WHERE emp.employee_id NOT IN
                            (SELECT mgr.manager_id
                            FROM employees mgr);
                            
SELECT emp.last_name
FROM employees emp
WHERE emp.employee_id IN
                        (SELECT mgr.manager_id
                        FROM employees mgr);
            
SELECT e.employee_id, d.manager_id,e.first_name,e.last_name
FROM employees e JOIN departments d
ON (e.manager_id = d.manager_id)
WHERE e.employee_id <> d.manager_id;

SELECT last_name,department_id
FROM employees
WHERE department_id IN (20,50)
ORDER BY last_name;

SELECT last_name,hire_date
FROM employees
WHERE hire_date LIKE '%4';

SELECT last_name, job_id
FROM employees
WHERE manager_id IS NULL;

SELECT last_name,salary,commission_pct
FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY salary DESC,commission_pct DESC;

SELECT last_name
FROM employees
WHERE last_name LIKE '__a%';

SELECT last_name
FROM employees
WHERE last_name LIKE '%a%'
AND last_name LIKE '%e%';

SELECT last_name,job_id,salary
FROM employees
WHERE job_id IN('SA_REP','ST_CLERK')
AND salary NOT IN(2500,3500,7000);

SELECT last_name ,length(last_name) "length"
FROM employees
WHERE last_name LIKE 'J%' OR last_name LIKE 'A%' OR last_name LIKE 'M%';

SELECT last_name , ROUND(MONTHS_BETWEEN(SYSDATE, hire_date)) MONTHS_WORKED
FROM employees 
ORDER BY MONTHS_BETWEEN(SYSDATE, hire_date);

SELECT e.department_id department, e.last_name employee,
c.last_name colleague
FROM employees e JOIN employees c
ON (e.department_id = c.department_id)
WHERE e.employee_id <> c.employee_id
ORDER BY e.department_id, e.last_name, c.last_name;

SELECT last_name, hire_date
FROM employees 
WHERE hire_date >(SELECT hire_date FROM employees WHERE last_name='Davies'); 

SELECT w.last_name, w.hire_date, m.last_name, m.hire_date
FROM employees w , employees m
WHERE w.manager_id = m.employee_id
AND w.hire_date < m.hire_date;


                                
SELECT e.last_name
FROM employees e
WHERE NOT EXISTS (SELECT 'manager'
                    FROM employees s 
                    WHERE s.manager_id = e.employee_id);   
                    
SELECT last_name
FROM employees e
WHERE EXISTS (SELECT 'employee'
                FROM employees e1
                WHERE e1.department_id =e.department_id
                AND e1.hire_date > e.hire_date
                AND e1.salary > e.salary);

SELECT e.employee_id,e.last_name,d.department_name
FROM employees e JOIN departments d
ON(e.department_id=d.department_id);

SELECT employee_id,last_name, (SELECT department_name
         FROM departments d
         WHERE e.department_id = d.department_id) department_name
FROM employees e
ORDER BY last_name;

WITH
summary AS (
SELECT department_name, SUM(salary) AS dept_total
FROM employees, departments
WHERE employees.department_id =departments.department_id
GROUP BY department_name)
SELECT department_name, dept_total
FROM summary
WHERE dept_total > (SELECT SUM(dept_total) * 1/8
FROM summary);

SELECT employee_id, job_id
FROM employees
UNION
SELECT employee_id, job_id
FROM job_history;

SELECT employee_id, job_id
FROM employees
UNION ALL
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;      
                                    
SELECT employee_id, job_id
FROM employees
INTERSECT
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;     

SELECT employee_id, job_id
FROM employees
MINUS
SELECT employee_id, job_id
FROM job_history
ORDER BY employee_id;    
                   
SELECT department_id,TO_NUMBER(null) location,hire_date
FROM employees
UNION 
SELECT department_id,location_id,TO_DATE(null)
FROM departments;
                                     
SELECT location_id,department_id
FROM departments
UNION 
SELECT location_id,TO_NUMBER(NULL)
FROM locations;

SELECT employee_id,job_id,salary
FROM employees
UNION
SELECT employee_id,job_id,0
FROM job_history;

COLUMN a_dummy NOPRINT
SELECT 'sing' AS "My dream",3 a_dummy
FROM dual
UNION
SELECT 'I''d like to teach',1 a_dummy
FROM dual
UNION
SELECT 'the world to',2 a_dummy
FROM dual
ORDER BY a_dummy;

INSERT INTO departments(department_id,department_name,manager_id,location_id)
VALUES(71,'Public Relations',100,1700);

INSERT INTO departments (department_id,department_name  )
VALUES (31,'Purchasing');

INSERT INTO departments
VALUES   (271,'Finance',NULL,NULL);

INSERT INTO employees (employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id)
VALUES(272,'Raju','Prem','Rajesh','pranathivarma@gmail.com','9848563421',SYSDATE,'AC_ACCOUNT',6900,NULL,205,71);

INSERT INTO employees
VALUES (114,'Den', 'Raphealy','DRAPHEAL','pranathivarma@gmail.com','9848563421', '515.127.4561',TO_DATE('FEB 3, 1999', 'MON DD, YYYY'),'SA_REP', 11000, 0.2, 100, 60);

INSERT INTO departments(department_id, department_name, location_id)
VALUES (&department_id, '&department_name',&location);

INSERT INTO sales_reps(id,name,salary,commission_pct)
SELECT employee_id,last_name,salary,commission_pct
FROM employees
WHERE job_id LIKE '%REP%';

UPDATE employees
SET department_id = 50
WHERE employee_id = 113;

UPDATE employees
SET job_id = (SELECT job_id FROM employees WHERE employee_id = 205),
    salary = (SELECT salary FROM employees WHERE employee_id = 205)
WHERE employee_id = 114;

DELETE FROM employees
WHERE department_id= (SELECT department_id FROM departments WHERE department_id LIKE '%71');

INSERT INTO locations (location_id,
street_address,postal_code,city,state_province,country_id)
VALUES (3300,'3/1 Ali Street','500008','Hyderabad','Telengana','IN');

SELECT * FROM locations;

INSERT INTO departments (department_id,
department_name, manager_ID, location_id)
VALUES (300,'Analytics',150, 3300);

SELECT * FROM departments;

INSERT INTO employees (employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id)
VALUES(207,'Pranathi','Varma','pranathivarma@gmail.com','96471239',SYSDATE,'AC_ACCOUNT',50000,0.05,150,300);

SELECT * FROM employees;

UPDATE employees
SET salary = 50000+(0.5*50000)
WHERE salary = 50000 AND employee_id=207;

DELETE FROM employees
WHERE employee_id=207 AND first_name='Pranathi'; 

DELETE FROM departments
WHERE department_id=300 AND department_name='Analytics';

SELECT * FROM employees WHERE department_id=50;

INSERT INTO (SELECT employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id 
             FROM employees
             WHERE department_id = 50)
VALUES (99999,'taylor','DTaylor','taylor@gmail.com',2589631472,TO_DATE('07-JUN-99','DD-MON-RR'),'ST_MAN',50000,0.5,120,50);

select * FROM locations;

UPDATE locations
SET city='Mysore'
WHERE location_id=3300 AND country_id='IN';

SAVEPOINT update_done;

INSERT INTO locations(location_id,street_address,postal_code,city,state_province,country_id)
VALUES (3500,'3/1 Ali baig Street','500008','Bangalore','Telengana','IN');

ROLLBACK TO update_done;

SELECT * FROM locations;

DELETE FROM locations
WHERE location_id = 3400;

DELETE FROM employees
WHERE employee_id=99999;

CREATE TABLE dept
            (deptno  NUMBER(2),
            dname VARCHAR2(14),
            loc   VARCHAR2(13),
            create_date DATE DEFAULT SYSDATE);
            
SELECT * FROM dept;

CREATE TABLE dept80
  AS
    SELECT employee_id,last_name,
           salary*12 ANNSAL,
           hire_date
    FROM   employees
    WHERE department_id = 80;
    
DESCRIBE dept80;

CREATE TABLE copyEmps
  AS 
    SELECT * FROM employees;
    
SELECT * FROM copyEmps;

DELETE FROM copyEmps;

ROLLBACK;

CREATE TABLE ROLES(
    RoleID number(5)
    constraint roleid_pk PRIMARY KEY,
    RoleName varchar(255)
    constraint rolename_nn NOT NULL
    );

CREATE TABLE USERS (
    UserID number(5)
    constraint userid_pk PRIMARY KEY,
    FName varchar(255)
    constraint fname_nn NOT NULL,
    UserName varchar2(10)
    constraint username_nn NOT NULL
    constraint username_uk UNIQUE,
    Password varchar2(255)
    constraint password_nn CHECK(LENGTH(Password)>=8),
    EmailId varchar2(255)
    constraint email_nn NOT NULL
    constraint email_uk UNIQUE,
    RoleId number(5)
    constraint roleid_fk REFERENCES
    ROLES (RoleId)
);

INSERT INTO ROLES (RoleId, RoleName)
VALUES (301, 'User');

INSERT INTO ROLES (RoleId, RoleName)
VALUES (302, 'Admin');

INSERT INTO ROLES (RoleId, RoleName)
VALUES (303, 'manager');


INSERT INTO USERS (UserId,FName,USERNAME, PASSWORD, EMAILID, ROLEID)
VALUES (33,'Priya','Priya96','5874396158','priya4432@gmail.com',301);

INSERT INTO USERS (UserId,FName,USERNAME, PASSWORD, EMAILID, ROLEID)
VALUES (32,'Hari','har86','8745120039','har4432@gmail.com',302);

INSERT INTO USERS (UserId,FName,USERNAME, PASSWORD, EMAILID, ROLEID)
VALUES (34,'Ansar','ansar45','5846921371','ansar75@gmail.com',303);

INSERT INTO USERS (UserId,FName,USERNAME, PASSWORD, EMAILID, ROLEID)
VALUES (35,'Reshma','Reshma21','2589631473','reshma75@gmail.com',301);

INSERT INTO USERS (UserId,FName,USERNAME, PASSWORD, EMAILID, ROLEID)
VALUES (36,'vinod','vinod56','7894561235','vinod74@gmail.com',302);

INSERT INTO USERS (UserId,FName,USERNAME, PASSWORD, EMAILID, ROLEID)
VALUES (37,'Yuktha','yuktha98','85245691735','yuktha@gmail.com',303);

CREATE VIEW empvu80
AS SELECT employee_id, last_name, salary
FROM employees
WHERE department_id = 80;

DESCRIBE empvu80

CREATE OR REPLACE VIEW empvu80
(id_number, name, sal, department_id)
AS SELECT employee_id, first_name || ' '
|| last_name, salary, department_id
FROM employees
WHERE department_id = 80;

CREATE OR REPLACE VIEW dept_sum_vu
(name, minsal, maxsal, avgsal)
AS SELECT d.department_name, MIN(e.salary),
MAX(e.salary),AVG(e.salary)
FROM employees e JOIN departments d
ON (e.department_id = d.department_id)
GROUP BY d.department_name;

CREATE OR REPLACE VIEW empvu20
AS SELECT *
    FROM employees
    WHERE department_id=20
    WITH CHECK OPTION CONSTRAINT empvu20_ck;
 
CREATE OR REPLACE VIEW empvu10
   (employee_number,employee_name,job_title)
AS SELECT  employee_id,last_name,job_id
     FROM employees
     WHERE department_id = 10
     WITH READ ONLY;
     
CREATE SEQUENCE users_id_seq
                INCREMENT BY 10
                START WITH 10
                MAXVALUE 9999
                NOCACHE
                NOCYCLE;
                
INSERT INTO roles(roleid,rolename)
VALUES   (1,'support');

SELECT * FROM ROLES

INSERT INTO roles(roleid,rolename)
VALUES   (1,'matter');
    
CREATE INDEX users_fname_idx
ON users(fname);

DESCRIBE DICTIONARY

SELECT * 
FROM dictionary

SELECT object_name,object_type,created,status
FROM user_objects
ORDER BY object_type;

DESCRIBE user_tables

SELECT table_name
FROM user_tables;

DESCRIBE user_tab_columns;

SELECT column_name,data_type,data_length,data_precision,data_scale,nullable
FROM user_tab_columns
WHERE table_name = 'USERS';

DESCRIBE user_constraints;

SELECT constraint_name,constraint_type,search_condition,r_constraint_name,delete_rule,status
FROM user_constraints
WHERE table_name='USERS';

DESCRIBE user_cons_columns;

SELECT constraint_name,column_name
FROM user_cons_columns
WHERE table_name='USERS';

SELECT DISTINCT view_name FROM user_views;

SELECT text FROM user_views
WHERE view_name = 'EMPVU80';

SELECT sequence_name,min_value,max_value,increment_by,last_number
FROM user_sequences;

SELECT * FROM user_synonyms;

COMMENT ON TABLE users
IS'Users Information';

SELECT * FROM USERS_TAB_COMMENTS;

SELECT * FROM USERS;
select * from roles;

select u.fname,u.username,u.emailid,r.rolename from users u,roles r 
				where u.roleid=r.roleid
                
select u.fname,u.username,u.emailid,r.rolename from users u,roles r where u.roleid=r.roleid;                

commit;

set serveroutput on;
DECLARE
  a NUMBER := 4;
BEGIN
  a := a+1;
  if mod(a,2)=0 then
    DBMS_output.put_line(a); 
  else
    DBMS_output.put_line(a+1); 
  end if;
END;
/

DECLARE
  i NUMBER := 1;
BEGIN
  LOOP
    INSERT INTO T1 VALUES(i,i);
    i := i+1;
    EXIT WHEN i>100;
  END LOOP;
END;
/

SELECT * FROM T1;
  
DECLARE
  i NUMBER := 1;
BEGIN
  WHILE i<100 LOOP
    INSERT INTO T1 VALUES(i,i);
    i := i+2;
  END LOOP;
END;
/

SELECT * FROM T1;

DECLARE
  a NUMBER := 1;
  i NUMBER :=1;
BEGIN
  FOR i IN 1..5 LOOP
    INSERT INTO T1 VALUES(a,a);
    a:=a+1;
  END LOOP;
END;
/
    
SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
 n_pct employees.commission_pct%TYPE;
 v_eval varchar2(10);
 n_emp_id employees.employee_id%TYPE := 145;
BEGIN
 --get commission percentage
 SELECT commission_pct
 INTO n_pct
 FROM employees
 WHERE employee_id = n_emp_id;
 --evaluate commission percentage
 CASE n_pct
  WHEN 0 THEN
    v_eval := 'N/A';
  WHEN 0.1 THEN
    v_eval := 'Low';
  WHEN 0.4 THEN
    v_eval := 'High';
  ELSE
    v_eval := 'Fair';
 ENd CASE;
 --print commission evaluation
 DBMS_OUTPUT.PUT_LINE('Employee'||n_emp_id||'commission'|| TO_CHAR(n_pct) ||
                       ' which is '   || v_eval);
END;
/  

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
 n_name USERS.FNAME%TYPE := 'Yuktha';
 v_eval VARCHAR2(20);
BEGIN
 SELECT r.rolename
 INTO v_eval
 FROM users u,roles r
 WHERE u.roleid=r.roleid AND u.fname=n_name;
 DBMS_OUTPUT.PUT_LINE(v_eval);
END;
/

CASE n_pct
  WHEN 'Reshma' THEN
    v_eval := '301';
  WHEN 'vinod' THEN
    v_eval := '302';
  WHEN 'Yuktha' THEN
    v_eval := '303';
  WHEN 'Hari' THEN
    v_eval := '301';
  WHEN 'Priya' THEN
    v_eval := '301';
  WHEN 'Ansar' THEN
    v_eval := '303';
  ELSE 
    v_eval := 'User does not exist'
 ENd CASE;
  
SELECT * FROM ROLES; 

DECLARE
  i NUMBER := 1;
BEGIN
  LOOP
    INSERT INTO T1 VALUES(i,i+1);
    i := i+1;
    EXIT WHEN i>100;
  END LOOP;
END;
/

SET SERVEROUTPUT ON SIZE 100000;
DECLARE
--declare a cursor
 CURSOR cur_chief IS
     SELECT last_name,hire_date,salary
     FROM copyemps
     where Extract(YEAR FROM hire_date)>='05';
  r_chief cur_chief%ROWTYPE;
 
 BEGIN
  OPEN cur_chief;
  LOOP
   FETCH cur_chief INTO r_chief;
   EXIT WHEN cur_chief%NOTFOUND;

   
   UPDATE copyemps SET salary = r_chief.salary+(0.1*r_chief.salary) ;
   
  END LOOP;
END; 
 /
 
 SELECT * FROM copyemps;
 



SET SERVEROUTPUT ON SIZE 100000;
DECLARE
--declare a cursor
 CURSOR cur_chief IS
     SELECT first_name,last_name
     FROM copyemps 
     Order by hire_date;
  r_chief cur_chief%ROWTYPE;
 
 BEGIN
  OPEN cur_chief;
  LOOP
   FETCH cur_chief INTO r_chief;
   EXIT WHEN cur_chief%NOTFOUND;

   SELECT *
     FROM copyemps 
     Order by hire_date;
     
     DBMS_OUTPUT.PUT_LINE(r_chief.first_name|| ' ' ||r_chief.last_name);
   
  END LOOP;
END; 
 /
 


DECLARE
 oldest_hire_date date;
 lname employee.last_name%TYPE;
 fname employee.first_name%TYPE;
 cursor find_oldest_hire_date is select min(hire_date) from employee;
 cursor id_employee is select last_name,first_name from employees where hire_date=oldest_hire_date;
 begin
  open find_oldest_hire_date;
  fetch find_oldest_hire_date into oldest_hire_date;
  close find_oldest_hire_date;
  open id_employee
  fetch id_employee into lname,fname;
  close id_employee;
 dbms_output.put_line('the oldest employee is' || lname || ' '||fname);
end;
/  

DECLARE 
n_pct employees.commission_pct%TYPE;
v_eval varchar2(10);
n_emp_id employees.employee_id%TYPE := 145;

BEGIN

SELECT commission_pct
INTO n_pct
FROM employees
WHERE employee_id = n_emp_id;

CASE n_pct
    WHEN 0 THEN
    v_eval:='N/A';
    WHEN 0.1 THEN
    v_eval:='Low';
    WHEN 0.4 THEN
    v_eval:='High';
    ELSE
    v_eval:='Fair';
    END CASE;
    
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE '||n_emp_id||' commission is '|| TO_CHAR(n_pct)||' which is '||v_eval);
    
    END;
    /
    
declare
begin
INSERT INTO employee_salary values(6,'Sri',53000,4000,1000,5000,15000,58000);
declare 
ename employee_salary.emp_name%TYPE:='&name';
tax_percent NUMBER:=0;
tax NUMBER:=0;
grossSal employee_salary.gross_salary%TYPE:=0;
BEGIN
select gross_salary into grossSal from employee_salary where emp_name=ename;

case 
when (grossSal>=15000 and grossSal<25000) then
tax_percent:=5;
when (grossSal>=25000 and grossSal<50000) then
tax_percent:=10;
when grossSal>=50000 then
tax_percent:=20;
end case;
tax:=tax_percent*grossSal/100;
dbms_output.put_line('Tax for '|| ename || ' is '||tax);
END;
end;
/

DECLARE
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT u.name,
             r.role_name
      FROM users u
      INNER JOIN roles r ON u.role_id = r.role_id;
 
  r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
 
    EXIT WHEN cur_chief%NOTFOUND;
 
    -- print department - chief
    DBMS_OUTPUT.PUT_LINE(r_chief.name|| ' - ' ||
                         r_chief.role_name);
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/

declare 
cursor cur_chief is select a,b from t1 where a<b for update;
r_chief cur_chief%ROWTYPE;
temp t1.a%type;
begin
open cur_chief;
loop
fetch cur_chief into r_chief;
exit when cur_chief%NOTFOUND;
temp:=r_chief.a;
update t1 set a=r_chief.b where b=r_chief.b;
update t1 set b=temp where b=r_chief.b;

end loop;
end;
/

declare
cursor cur_chief is select employee_id,first_name,salary,hire_date from employees where hire_date>TO_DATE('31-Dec-2004');
r_chief cur_chief%ROWTYPE;
begin
OPEN cur_chief;
loop
fetch cur_chief into r_chief;
exit when cur_chief%NOTFOUND;
dbms_output.put_line(r_chief.first_name||q'['s]'||' updated salary is '||(r_chief.salary*0.1+r_chief.salary));

end loop;
end;
/

declare
cursor cur_chief is select last_name,first_name,hire_date from employees;
r_chief cur_chief%ROWTYPE;
oldDate employees.hire_date%TYPE:=sysdate;
first_name employees.first_name%TYPE;
last_name employees.last_name%TYPE;
begin
open cur_chief;
loop
fetch cur_chief into r_chief;
exit when cur_chief%NOTFOUND;
if r_chief.hire_date<oldDate 
then
oldDate:=r_chief.hire_date;
first_name:=r_chief.first_name;
last_name:=r_chief.last_name;
end if;
end loop;
dbms_output.put_line(first_name||' '||last_name||' is the oldest employee hired on '||oldDate);
end; 
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  r_emp employees%ROWTYPE;
  n_emp_id  employees.employee_id%TYPE := 200;
BEGIN
  SELECT *
  INTO r_emp
  FROM employees
  WHERE employee_id = n_emp_id;
  -- print out the employee's first name
  DBMS_OUTPUT.PUT_LINE(r_emp.first_name);
END;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  TYPE t_name IS RECORD(
     first_name employees.first_name%TYPE,
     last_name  employees.last_name%TYPE
  );
  r_name   t_name; -- name record
  n_emp_id employees.employee_id%TYPE := 200;
BEGIN
  SELECT first_name,
         last_name
  INTO r_name
  FROM employees
  WHERE employee_id = n_emp_id;
  -- print out the employee's name
  DBMS_OUTPUT.PUT_LINE(r_name.first_name || ',' || r_name.last_name );
END;
/

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  TYPE t_name IS RECORD(
     user_name users.username%TYPE,
     role_name  roles.rolename%TYPE
  );
  r_name   t_name; -- name record
  u_name users.username%TYPE := 200;
BEGIN
  SELECT first_name,
         last_name
  INTO r_name
  FROM employees
  WHERE employee_id = n_emp_id;
  -- print out the employee's name
  DBMS_OUTPUT.PUT_LINE(r_name.first_name || ',' || r_name.last_name );
END;
/

declare
    type t_users is record(
        user_name users.fname%TYPE,
        role_name roles.rolename%TYPE
        );
    cursor cur_chief is select u.fname,r.rolename from users u join roles r on u.roleid=r.roleid;
    r_users t_users;
begin
    open cur_chief;
    loop
        fetch cur_chief into r_users;
        exit when cur_chief%NOTFOUND;
        dbms_output.put_line(r_users.user_name ||' - '||r_users.role_name);
    end loop;
    close cur_chief;
end;
/

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  CURSOR cur_emp IS
    SELECT *
    FROM employees
    WHERE employee_id = 200;
 
  emp_rec cur_emp%ROWTYPE;
BEGIN
  NULL;
END;
/

SET serveroutput ON SIZE 1000000;
DECLARE
  TYPE t_name IS RECORD(
    first_name employees.first_name%TYPE,
    last_name employees.last_name%TYPE
  );
  r_name      t_name;
  r_name2     t_name;
  r_name_null t_name;
  n_emp_id employees.employee_id%TYPE := 200;
BEGIN
  -- assign employee's infomation to record
  SELECT first_name,
         last_name
  INTO r_name
  FROM employees
  WHERE employee_id = n_emp_id;
 
  -- assign record to another record
  r_name2 := r_name;
  -- print out the employee's name
  DBMS_OUTPUT.PUT_LINE(r_name2.first_name || ',' || r_name2.last_name);
 
  -- assign record to NULL
  r_name2 := r_name_null; 
 
  -- check NULL for each individual field
  IF r_name2.first_name IS NULL AND
     r_name2.last_name IS NULL THEN
    DBMS_OUTPUT.PUT_LINE('Record r_name2 is NULL');
  END IF;
 
END;
/


DECLARE
  TYPE t_address IS RECORD(
    house_number VARCHAR2(6),
    street       VARCHAR2(50),
    phone        VARCHAR2(15),
    region       VARCHAR2(10),
    postal_code  VARCHAR2(10),
    country      VARCHAR2(25)
  );
 
  TYPE t_contact IS RECORD(
    home     t_address,
    business t_address
  );
  r_contact t_contact;
BEGIN
  r_contact.business.house_number := '500';
  r_contact.business.street       := 'Oracle Parkway';
  r_contact.business.region       := 'CA';
  r_contact.business.postal_code  := '94065';
  r_contact.business.country      := 'USA';
  r_contact.business.phone        := '+1.800.223.1711';
END;


declare
cursor cur_chief is select e.first_name, e.last_name, d.department_id,
d.location_id from employees e join departments d on (e.department_id = d.department_id);
type t_emp is record(
first_name employees.first_name%type,
last_name employees.last_name%type);

type t_dept is record(
dept_id departments.department_id%type,
loc_id departments.location_id%type);

type t_loc is record(
dept t_dept, lname t_emp);
r_loc t_loc;
begin
open cur_chief;
loop
fetch cur_chief into r_loc.lname.first_name, r_loc.lname.last_name, r_loc.dept.dept_id, r_loc.dept.loc_id;
exit when cur_chief%NOTFOUND;
dbms_output.put_line(r_loc.lname.first_name||' - '||r_loc.lname.last_name||' - '||r_loc.dept.loc_id||' - '||r_loc.dept.dept_id);
end loop;
end;


SET serveroutput ON SIZE 1000000;
DECLARE
    l_name employees.LAST_NAME%TYPE;
    l_emp_id employees.EMPLOYEE_ID%TYPE := &employee_id;
BEGIN
    -- get the customer
    SELECT last_name INTO l_name
    FROM employees
    WHERE employee_id = l_emp_id;
    
    -- show the customer name   
    dbms_output.put_line('employee name is ' || l_name);
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            dbms_output.put_line('employee ' || l_emp_id ||  ' does not exist');
        WHEN TOO_MANY_ROWS THEN
            dbms_output.put_line('The database returns more than one customer');     
END;
/

SELECT * FROM employees;

DECLARE
    password_too_small EXCEPTION;
    PRAGMA exception_init( password_too_small, -20001 );
    l_password users.password%TYPE := '&password';
BEGIN
    -- check if input credit is greater than the max credit
    IF length(l_password) < 8 THEN 
        --RAISE password_too_small;
        raise_application_error(-20001,'password too small');
    END IF;
    dbms_output.put_line(l_password);
END;
/

DECLARE 
     salary_beyond_limit EXCEPTION;
     PRAGMA exception_init(salary_beyond_limit, -20001);
     l_employeeid copyemps.employee_id%TYPE:=&employee_id;
     l_salary copyemps.salary%TYPE := &salary;
     l_min_salary jobs.min_salary%TYPE;
     l_max_salary jobs.max_salary%TYPE;
BEGIN
     SELECT l_min_salary,l_max_salary from jobs where job_id=(select job_id from copyemps where employee_id = l_employeeid);
     IF l_salary>l_max_salary OR l_salary<l_min_salary then
           raise_application_error(-20001,'salary beyond limit');
     END IF;
           update copyemps
           set salary = l_salary
           where employee_id = l_employee_id;
     
END;
/

----------------------------------------------------------
CREATE OR REPLACE 
PROCEDURE HELLO IS
BEGIN
   DBMS_OUTPUT.PUT_LINE('Hello World');
END;   
/

call Hello();
------------------------------------------------------------------
CREATE OR REPLACE 
PROCEDURE DISPN (N INT) IS
BEGIN
   DBMS_OUTPUT.PUT_LINE('the square of '||N||' is ' || N*N);
END; 
/

CALL DISPN(123456789);

DECLARE 
num NUMBER := &number;
BEGIN
   DISPN(num);
END;
/
--------------------------------------------
CREATE OR REPLACE 
PROCEDURE DISP_EMP (emp_id INT) IS
    l_empid employees.employee_id%TYPE;
    l_lname employees.last_name%TYPE;
    l_salary employees.salary%TYPE;
BEGIN
     SELECT employee_id,last_name,salary 
     INTO l_empid,l_lname,l_salary
     FROM employees;
     DBMS_OUTPUT.PUT_LINE('the details of the employee'||l_empid||'are , name: '||l_lname||' salary: '||l_salary);
END;
/
-----------------------------------------------------
CREATE OR REPLACE
PROCEDURE SUM_AB( A INT, B INT, C OUT INT) IS
BEGIN
  C := A + B;
END;
/

DECLARE 
   R INT;
BEGIN
   SUM_AB(23,29,R);
   DBMS_OUTPUT.PUT_LINE('sum is: '||R);
END;
/
---------------------------------
SET SERVEROUTPUT ON
CREATE OR REPLACE
PROCEDURE DISPEMPNAME(EMPID INT)IS
        L_EMPID EMPLOYEES.EMPLOYEE_ID%TYPE;
        L_FNAME EMPLOYEES.FIRST_NAME%TYPE;
        L_LNAME EMPLOYEES.LAST_NAME%TYPE;
        
BEGIN
    SELECT FIRST_NAME,LAST_NAME
    INTO L_FNAME,L_LNAME
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID=EMPID;
    DBMS_OUTPUT.PUT_LINE(L_FNAME||' '||L_LNAME);
END;
/

DECLARE
    L_EMPLOYEEID EMPLOYEES.EMPLOYEE_ID%TYPE:=&EMPID;
BEGIN
    DISPEMPNAME(L_EMPLOYEEID);
END;
/

-------------------------

CREATE OR REPLACE
PROCEDURE DISPSALARY(EMPID INT)IS
        L_EMPID EMPLOYEES.EMPLOYEE_ID%TYPE;
        SALARY EMPLOYEES.SALARY%TYPE;
        
        
BEGIN
    SELECT SALARY
    INTO SALARY
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID=EMPID;
    DBMS_OUTPUT.PUT_LINE(SALARY);
END;
/

DECLARE
    L_EMPLOYEEID EMPLOYEES.EMPLOYEE_ID%TYPE:=&EMPID;
BEGIN
    DISPSALARY(L_EMPLOYEEID);
END;
/


CREATE OR REPLACE
PROCEDURE DISPempsalary( l_employeeid employees.employee_id%TYPE,l_salary OUT employees.salary%TYPE) IS 

BEGIN
    SELECT salary
    INTO l_salary
    FROM EMPLOYEES
    WHERE employee_id=l_employeeid;
    
END;
/
------------------------------------------
SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    R employees.salary%TYPE;
    l_employeeid employees.employee_id%TYPE :=&empid;
BEGIN
    DISPempsalary(l_employeeid,R);
     DBMS_OUTPUT.PUT_LINE(R);
END;
/
----------------------------------------------------

CREATE TABLE audits (
      audit_id         NUMBER PRIMARY KEY,
      table_name       VARCHAR2(255),
      transaction_name VARCHAR2(10),
      by_user          VARCHAR2(30),
      transaction_date DATE
);

CREATE OR REPLACE TRIGGER user_audit_trg
    AFTER 
    UPDATE OR DELETE 
    ON USERS
    FOR EACH ROW    
DECLARE
   l_transaction VARCHAR2(10);
BEGIN
   -- determine the transaction type
   l_transaction := CASE  
         WHEN UPDATING THEN 'UPDATE'
         WHEN DELETING THEN 'DELETE'
   END;
 
   -- insert a row into the audit table   
   INSERT INTO audits (audit_id, table_name, transaction_name, by_user, transaction_date)
   VALUES(users_id_seq.nextval,'USERS', l_transaction, USER, SYSDATE);
END;
/

SELECT * FROM USERS;
-----------------------------------------------

CREATE OR REPLACE PACKAGE personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER)
    RETURN VARCHAR2;
  -- get employee's salary
  FUNCTION get_salary(n_emp_id NUMBER)
    RETURN NUMBER;
END personnel;


CREATE OR REPLACE PACKAGE BODY personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER) RETURN VARCHAR2 IS
      v_fullname VARCHAR2(46);
  BEGIN
    SELECT first_name || ',' ||  last_name
    INTO v_fullname
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN v_fullname;
 
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  WHEN TOO_MANY_ROWS THEN
    RETURN NULL;
  END; -- end get_fullname
 
  -- get salary
  FUNCTION get_salary(n_emp_id NUMBER) RETURN NUMBER IS
    n_salary NUMBER(8,2);
  BEGIN
    SELECT salary
    INTO n_salary
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN n_salary;
 
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RETURN NULL;
      WHEN TOO_MANY_ROWS THEN
        RETURN NULL;
  END;
END personnel;


