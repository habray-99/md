dfd 0 [
    customer_id,customer_category_id
    invoice_id
    driver_id
    service_id
    vehicle_id


    customer_name
    customer_address
    customer_phone
    reward
    customer_category_name
    customer_category_desc
    discount
    total
    date
    driver_name
    driver_address
    driver_phone
    driver_type
    salary
    vehicle_type
    vehicle_fuel_type
    vehicle_cost
    vehicle_model
    vehicle_variants
    vehicle_company
    service_type    
    estimated_duration
    estimated_total
    distance 

]

dfd 1 [

    customer(       
        customer_id, customer_category_id
        customer_name, customer_address, customer_phone, reward, customer_category_name, customer_category_desc, discount, 
    )
    service_ticket(
        service_id, vehicle_id, driver_id, customer_id, invoice_id
        total, date, driver_name, driver_address, driver_phone, driver_type, salary, vehicle_type, vehicle_fuel_type, vehicle_cost, vehicle_model, vehicle_variants, vehicle_company, service_type, estimated_duration, estimated_total, distance
    )
]

dfd 2 [

customer_id, service_id, vehicle_id, driver_id, invoice_id  ==> estimated_duration, distance, total
service_id ==> service_type
vehicle_id ==> vehicle_type, vehicle_fuel_type, vehicle_cost
driver_id ==> driver_name, driver_address, driver_phone, driver_type, salary
invoice_id ==> invoice_date, total, customer_id, driver_id, service_id, vehicle_id


    customer(
        customer_id, customer_name, customer_phone, customer_address, reward

        customer_category_id, customer_category_name, customer_category_desc, discount
    )

    service_ticket(
        customer_id
        service_id
        vehicle_id
        invoice_id
        estimated_duration
        estimated_total
        distance 
    )

    service(
        service_id
        service_type
    )

    vehicle(
        vehicle_id
        vehicle_type
        vehicle_fuel_type
        vehicle_cost
        vehicle_model
        vehicle_variants
        vehicle_company
        driver_id
    )

    driver(
        driver_id
        driver_name
        driver_address
        driver_phone
        driver_type         /* full or part time */
        salary
    )

    invoice(
        invoice_id
        total
        date
        customer_id
        service_id
        vehicle_id
        driver_id
    )

]

dfd 3 [
customer_id ==> customer_category_id, customer_name, customer_address, customer_phone
customer_category_id ==> customer_category_name
    customer(
        customer_id
        customer_name
        customer_address
        customer_phone
        reward
        customer_category_id
    )

    customer_category(
        customer_category_id
        customer_category_name
        customer_category_desc
        discount
    )
    
    service_ticket(
        customer_id
        service_id
        vehicle_idvehicle_id
        invoice_id
        estimated_duration
        estimated_total
        distance 
    )

    service(
        service_id
        service_type
    )

    vehicle(
        vehicle_id
        vehicle_type
        vehicle_fuel_type
        vehicle_cost
        vehicle_model
        vehicle_variants
        vehicle_company
        driver_id
    )

    driver(
        driver_id
        driver_name
        driver_address
        driver_phone
        driver_type
        salary
    )

    invoice(
        invoice_id
        total
        date
        customer_id
        service_id
        vehicle_id
        driver_id
    )
]