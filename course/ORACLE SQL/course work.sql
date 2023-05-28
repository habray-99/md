-- sys as SYSDBA
-- conn sys as SYSDBA;
-- CREATE USER vamsha1 IDENTIFIED by vamshaA;


/* GRANT ALL PRIVILEGE TO vamsha1;
ALTER USER VAMSHA1 IDENTIFIED BY VAMSHA; */

-- conn vamsha1/vamshaa
sys as SYSDBA

/* conn cw/test


create table test1I(speed int, name int);
drop table custromers_category; */
-- customer catalog table
hey i made this 
```
create table custromers_category(
    customer_category_id int PRIMARY KEY,
    customer_category_name VARCHAR2(255) NOT NULL,
    disocunt number(3) not null
);
INSERT ALL
    INTO custromers_category VALUES (1,'employees',10)
    INTO custromers_category VALUES (2,'regular',7)
    INTO custromers_category VALUES (3,'relatives',7) 
    INTO custromers_category VALUES (5,'no',0)
    select * from DUAL;

SELECT c.customer_name, cc.customer_category_name
FROM customers c
INNER JOIN custromers_category cc ON c.customer_category_id = cc.customer_category_id;


-- customer table structure
create table customers(
    customer_id NUMBER(10) PRIMARY KEY,
    customer_name VARCHAR2(255) NOT NULL,
    customer_phone VARCHAR2(10) not null UNIQUE,
    customer_address VARCHAR2(100) not NULL,
    reward NUMBER(7),
    customer_category_id NUMBER(10) not NULL,
    FOREIGN KEY (customer_category_id) REFERENCES custromers_category(customer_category_id) 
    );
INSERT all 
    INTO customers VALUES (1,'ram','1111111111','pokhara',100,2)
    INTO customers VALUES (2,'shyam','2222222222','kathmandu',200,2)
    INTO customers VALUES (3,'hari','3333333333','dharan',50,5)
    INTO customers VALUES (4,'nischal','4444444444','illam',25,3)
    INTO customers VALUES (5,'samir','5555555555','rolpa',75,1)
    INTO customers VALUES (6,'loken','6666666666','dumray',40,2)
    INTO customers VALUES (7,'nishan','7777777777','kotray',80,3)
    select * from dual;






-- services tableA 
create table SERVICES(
    SERVICE_ID NUMBER(10) PRIMARY KEY,
    SERVICE_TYPE VARCHAR2(100) NOT NULL
);
insert all
    into SERVICES (SERVICE_ID, SERVICE_TYPE) VALUES (1,'food dilivary service')
    into SERVICES (SERVICE_ID, SERVICE_TYPE) VALUES (2,'equipment dilivary service')
    into SERVICES (SERVICE_ID, SERVICE_TYPE) VALUES (3,'package dilivary')
    into SERVICES (SERVICE_ID, SERVICE_TYPE) VALUES (4,'human transportation')
    into SERVICES (SERVICE_ID, SERVICE_TYPE) VALUES (6,'cab hires service')
    into SERVICES (SERVICE_ID, SERVICE_TYPE) VALUES (7,'rent vehicle')
    select * from dual;

-- driver table

INSERT all 
    INTO drivers(driver_id, driver_name, driver_phone, driver_address, driver_type, salary) values(1,'driver 1','9800000000','chauthe','full time',1400)
    INTO drivers(driver_id, driver_name, driver_phone, driver_address, driver_type, salary) values(2,'driver 2','9800000001','chinn dada','full time',1300)
    INTO drivers(driver_id, driver_name, driver_phone, driver_address, driver_type, salary) values(3,'drisver 3','9800000002','0 km','full time',1200)
    INTO drivers(driver_id, driver_name, driver_phone, driver_address, driver_type, salary) values(4,'driver 4','9800000003','new road','full time',1250)
    INTO drivers(driver_id, driver_name, driver_phone, driver_address, driver_type, salary) values(5,'driver 5','9800000004','parsyang','part time',800)
    INTO drivers(driver_id, driver_name, driver_phone, driver_address, driver_type, salary) values(6,'driver 6','9800000005','siddhartha chowk','part time',750)
    INTO drivers(driver_id, driver_name, driver_phone, driver_address, driver_type, salary) values(7,'drisver 7','9800000006','bp marga','part time',720)
    INTO drivers(driver_id, driver_name, driver_phone, driver_address, driver_type, salary) values(8,'Adam 8','9800000008','lake side','part time',700)
    select * from DUAL;

-- vehicles table
create table vehicle(
    vehicle_id NUMBER(15) not null PRIMARY KEY,
    vehicle_type VARCHAR2(100) NOT NULL,
    vehicle_fuel_type VARCHAR2(20) NOT NULL,
    vehicle_cost NUMBER(10) NOT NULL,
    vehicle_model VARCHAR2(20) NOT NULL,
    vehicle_variants number(10) NOT NULL,
    vehicle_company VARCHAR2(20) NOT NULL,
    driver_id NUMBER(10) NOT NULL,
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);
INSERT ALL
    into vehicle(vehicle_id,vehicle_type,vehicle_fuel_type,vehicle_cost,vehicle_company,vehicle_model,vehicle_variants,driver_id) VALUES (1,'bike','elerticity',40,'honda','cf500',2015,1)
    into vehicle(vehicle_id,vehicle_type,vehicle_fuel_type,vehicle_cost,vehicle_company,vehicle_model,vehicle_variants,driver_id) VALUES (2,'pick up truck','diesel',75,'toyota','hilux', 2015,4)
    into vehicle(vehicle_id,vehicle_type,vehicle_fuel_type,vehicle_cost,vehicle_company,vehicle_model,vehicle_variants,driver_id) VALUES (3,'bike','Patrol',50,'BMW','h',2017,5) 
    into vehicle(vehicle_id,vehicle_type,vehicle_fuel_type,vehicle_cost,vehicle_company,vehicle_model,vehicle_variants,driver_id) VALUES (4,'car','Patrol',70,'Mercedes benz','SLS',2013,2) 
    into vehicle(vehicle_id,vehicle_type,vehicle_fuel_type,vehicle_cost,vehicle_company,vehicle_model,vehicle_variants,driver_id) VALUES (5,'pick up truck','elerticity',80,'tesla','cyber truck',2018,3)
    into vehicle(vehicle_id,vehicle_type,vehicle_fuel_type,vehicle_cost,vehicle_company,vehicle_model,vehicle_variants,driver_id) VALUES (6,'tow truck','diesel',85,'kenwood','BF3000',2019,4) 
    into vehicle(vehicle_id,vehicle_type,vehicle_fuel_type,vehicle_cost,vehicle_company,vehicle_model,vehicle_variants,driver_id) VALUES (7,'truck','diesel',100,'tata','BW3600',2017,8) 
    select * from DUAL;



-- INVOICE table
CREATE TABLE invoice(
    invoice_id NUMBER(10) NOT NULL,
    total NUMBER(10) NOT NULL,
    customer_id number(10),
    service_id number(10),
    vehicle_id number(15),
    driver_id number(10),
    invoice_date DATE,
    PRIMARY KEY(invoice_id/* , customer_id,SERVICE_ID, vehicle_id,driver_id */),
    FOREIGN key (customer_id) REFERENCES customers(customer_id),
    FOREIGN key (SERVICE_ID) REFERENCES SERVICES(SERVICE_ID),
    FOREIGN key (vehicle_id) REFERENCES vehicle(vehicle_id),
    FOREIGN key (driver_id) REFERENCES drivers(driver_id)
);
insert ALL
    into INVOICE(invoice_id, total, customer_id, service_id, vehicle_id, driver_id, invoice_date) VALUES(1,936,1,1,1,1,to_date('2022-03-05','yyyy-MM-dd'))
    into INVOICE(invoice_id, total, customer_id, service_id, vehicle_id, driver_id, invoice_date) VALUES(2,2205,1,6,4,2,to_date('2022-03-08','yyyy-MM-dd'))
    into INVOICE(invoice_id, total, customer_id, service_id, vehicle_id, driver_id, invoice_date) VALUES(3,3441,2,6,3,5,to_date('2022-03-11','yyyy-MM-dd'))
    into INVOICE(invoice_id, total, customer_id, service_id, vehicle_id, driver_id, invoice_date) VALUES(4,1395,3,2,7,8,to_date('2022-03-15','yyyy-MM-dd'))
    into INVOICE(invoice_id, total, customer_id, service_id, vehicle_id, driver_id, invoice_date) VALUES(5,640,4,6,1,1,to_date('2022-03-20','yyyy-MM-dd'))
    into INVOICE(invoice_id, total, customer_id, service_id, vehicle_id, driver_id, invoice_date) VALUES(6,3312,5,3,5,3,to_date('2022-03-25','yyyy-MM-dd'))
    into INVOICE(invoice_id, total, customer_id, service_id, vehicle_id, driver_id, invoice_date) VALUES(7,1976,6,3,6,4,to_date('2022-03-30','yyyy-MM-dd'))
    into INVOICE(invoice_id, total, customer_id, service_id, vehicle_id, driver_id, invoice_date) VALUES(8,595,7,1,1,8,to_date('2022-04-02','yyyy-MM-dd'))
    select * from DUAL;

SELECT *
FROM service_ticket
WHERE service_date BETWEEN '2022-03-05' AND '2022-04-05';


-- SERVICES TICKET table

CREATE TABLE service_ticket(
    service_ticket_id INTEGER,
    customer_id NUMBER(10),
    service_id  NUMBER(10),
    vehicle_id NUMBER(15),
    invoice_id NUMBER(10),
    estimated_duration NUMBER(10) NOT NULL,
    estimated_total NUMBER(10) NOT NULL,
    distance NUMBER(10) NOT NULL,
    PRIMARY KEY(service_ticket_id,customer_id,SERVICE_ID, vehicle_id, invoice_id),
    FOREIGN key (customer_id) REFERENCES customers(customer_id),
    FOREIGN key (SERVICE_ID) REFERENCES SERVICES(SERVICE_ID),
    FOREIGN key (vehicle_id) REFERENCES vehicle(vehicle_id),
    FOREIGN KEY (invoice_id) REFERENCES invoice(invoice_id)
);
insert ALL
    INTO service_ticket(service_ticket_id,customer_id, service_id, vehicle_id, invoice_id, estimated_duration, estimated_total, distance) VALUES(1,1,1,1,1,120,1040,26)
    INTO service_ticket(service_ticket_id,customer_id, service_id, vehicle_id, invoice_id, estimated_duration, estimated_total, distance) VALUES(2,1,6,4,2,70,2450,35)
    INTO service_ticket(service_ticket_id,customer_id, service_id, vehicle_id, invoice_id, estimated_duration, estimated_total, distance) VALUES(3,2,6,3,3,60,3700,74)
    INTO service_ticket(service_ticket_id,customer_id, service_id, vehicle_id, invoice_id, estimated_duration, estimated_total, distance) VALUES(4,3,2,7,4,75,1500,15)
    INTO service_ticket(service_ticket_id,customer_id, service_id, vehicle_id, invoice_id, estimated_duration, estimated_total, distance) VALUES(5,4,6,1,5,65,640,16)
    INTO service_ticket(service_ticket_id,customer_id, service_id, vehicle_id, invoice_id, estimated_duration, estimated_total, distance) VALUES(6,5,3,5,6,85,3680,46)
    INTO service_ticket(service_ticket_id,customer_id, service_id, vehicle_id, invoice_id, estimated_duration, estimated_total, distance) VALUES(7,6,3,6,7,99,2125,25)
    INTO service_ticket(service_ticket_id,customer_id, service_id, vehicle_id, invoice_id, estimated_duration, estimated_total, distance) VALUES(8,7,1,1,8,77,640,16)
    select * from dual;
```

--   List all customers according to category
SELECT customers.customer_name, customer_category.customer_category_name
FROM customers
JOIN customer_category
ON customers.customer_category_id = customer_category.customer_category_id
ORDER BY customer_category.customer_category_name;


-- Find model and vehicle variants and sort by price in descending order.
SELECT vehicle.vehicle_model, vehicle.vehicle_variants, vehicle.vehicle_cost
FROM vehicle
ORDER BY vehicle.vehicle_cost DESC;


-- Display the number of total vehicles that use petrol.
SELECT COUNT(*)
FROM vehicle
WHERE vehicle.vehicle_fuel_type = 'petrol';


-- List all tickets issued from 2022/03/05 to 2022/04/05.
SELECT st.customer_id, st.service_id, st.vehicle_id, st.invoice_id, st.estimated_duration, st.estimated_total, st.distance
FROM service_ticket st
WHERE service_ticket.invoice_id IN (SELECT invoice.invoice_id
                                   FROM invoice
                                   WHERE invoice.invoice_date BETWEEN to_date('2022-03-05','yyyy-mm-dd') AND to_date('2022-04-05','yyyy-mm-dd'));

SELECT c.customer_name, SUM(st.estimated_total) AS total_cost, st.service_type, i.invoice_date
FROM service_ticket st
inner join SERVICES s on s.service_id = st.service_id
FROM service_ticket 
inner JOIN customers c ON s.customer_id = c.customer_id
from invoice i 
inner join s on s.invoice_id = i.invoice_id 
WHERE s.service_date BETWEEN to_date('2022-01-01','yyyy-mm-dd') AND to_date('2022-12-32','yyyy-mm-dd');
GROUP BY c.customer_name, s.service_type;


```````````````````
SELECT c.customer_name, s.service_type, st.invoice_id, st.distance, i.invoice_date 
FROM service_ticket st on customers.customer_id = service_ticket.customer_id
from service_ticket on SERVICES.service_id = st.service_id
from INVOICE on invoice.invoice_id = st.invoice_id
WHERE invoice.invoice_date BETWEEN to_date('2022-01-01','yyyy-mm-dd') AND to_date('2022-12-32','yyyy-mm-dd'));


--  List the name of the driver who has the character ‘s’ between their names.
SELECT drivers.driver_name
FROM drivers
WHERE drivers.driver_name LIKE '%s%';


/*  6.2. Transactional Queries
Q: Show the total cost and the type of service of a particular customer in a year that has used the service. */
SELECT customers.customer_name, SUM(invoice.total) AS total_cost, services.service_type
FROM customers
JOIN invoice
ON customers.customer_id = invoice.customer_id
JOIN services on SERVICES.SERVICE_ID = .service_id
ON invoice.service_id = services.service_id
WHERE invoice.date BETWEEN to_date('2022-01-01','yyyy-mm-dd') AND to_date('2022-12-31','yyyy-mm-dd')
GROUP BY customers.customer_name, services.service_type;


SELECT c.customer_name, s.service_type, SUM(i.total) as total_cost
FROM customers c
JOIN invoice i ON c.customer_id = i.customer_id
JOIN services s ON s.service_id = i.service_id
i.invoice_date BETWEEN to_date('2022-01-01','yyyy-mm-dd') AND to_date('2022-12-31','yyyy-mm-dd')
GROUP BY c.customer_name, s.service_type;


-- List the details of services that have been provided by a driver for the current month whose first name starts with the letter ‘A’.
SELECT drivers.driver_name, services.service_type, invoice.total
FROM drivers
JOIN invoice
ON drivers.driver_id = invoice.driver_id
JOIN services
ON invoice.service_id = services.service_id
WHERE drivers.driver_name LIKE 'A%'
AND invoice.date BETWEEN '2022-08-01' AND '2022-08-31';


SELECT d.driver_name, s.service_type, i.total
FROM drivers d
JOIN invoice i ON d.driver_id = i.driver_id
JOIN services s ON s.service_id = i.service_id
WHERE d.driver_name LIKE 'A%' AND i.invoice_date BETWEEN to_date('2022-01-01', 'yyyy-mm-dd') AND to_date('2022-12-32', 'yyyy-mm-dd')



-- List the details of customers who have used only courier service and their location of delivery.
SELECT customers.customer_name, customers.customer_address, services.service_type
FROM customers
JOIN invoice
ON customers.customer_id = invoice.customer_id
JOIN services
ON invoice.service_id = services.service_id
WHERE services.service_type = 'courier';


-- List all the details of the top 3 highest earning drivers.
SELECT drivers.driver_name, drivers.driver_phone, drivers.driver_address, drivers.driver_type, drivers.salary
FROM drivers
ORDER BY drivers.salary DESC
LIMIT 3;

SELECT *
FROM (
   SELECT d.Driver_Name, SUM(i.Total) as "Total Earnings"
   FROM invoice i
   JOIN drivers d ON i.Driver_ID = d.Driver_ID
   GROUP BY d.Driver_Name
   ORDER BY SUM(i.Total) DESC
)
WHERE ROWNUM <= 3;

select * from driver order by drivers.salary desc
where ROWNUM <=3

-- Display the rate of all vehicles for staff and normal customers on a particular destination.
SELECT vehicle.vehicle_type, vehicle.vehicle_cost
FROM vehicle
JOIN invoice
ON vehicle.vehicle_id = invoice.vehicle_id
WHERE invoice.destination = 'particular destination'
AND invoice.customer_id IN (SELECT customer_id
                            FROM customers
                            WHERE customer_category_id = 'staff')
UNION
SELECT vehicle.vehicle_type, vehicle.vehicle_cost
FROM vehicle
JOIN invoice
ON vehicle.vehicle_id = invoice.vehicle_id
WHERE invoice.destination = 'particular destination'
AND invoice.customer_id IN (SELECT customer_id
                            FROM customers
                            WHERE customer_category_id = 'normal');

SELECT customers.customer_name, customers.customer_address, customers.customer_phone 
FROM customers JOIN service_ticket
on service_ticket.customer_id = customers.customer_id
where SERVICE_ID = 3;



change the following 
```sql


```
into Relational algebra 