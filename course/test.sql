select * from customers;

select * from services;

select * from custromers_category;

select * from vehicle;
select * from invoice;
select * from SERVICE_TICKET;


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


drop table service_ticket;

CREATE TABLE service_ticket(
    service_ticket_id INTEGER,
    customer_id NUMBER(10),
    service_id  NUMBER(10),
    vehicle_id NUMBER(15),
    invoice_id NUMBER(10),
    estimated_duration NUMBER(10) NOT NULL,
    estimated_total NUMBER(10) NOT NULL,
    distance NUMBER(10) NOT NULL,
    PRIMARY KEY(service_ticket_id, customer_id,SERVICE_ID, vehicle_id, invoice_id),
    FOREIGN key (customer_id) REFERENCES customers(customer_id),
    FOREIGN key (SERVICE_ID) REFERENCES SERVICES(SERVICE_ID),
    FOREIGN key (vehicle_id) REFERENCES vehicle(vehicle_id),
    FOREIGN KEY (invoice_id) REFERENCES invoice(invoice_id)
);





    
    commit;