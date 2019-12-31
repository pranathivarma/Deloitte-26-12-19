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


        
                   
   
   
                                     




