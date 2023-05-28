{
    customer_id
    customer_name
    customer_address
    customer_phone

    customer_category
    customer_category_id
    customer_category_name


    vehicale_ID
    vehicle_type
    vehicle_model
    vehicle_brand

    driver_id
    driver_name
    driver_address
    driver_phone

    service_type_id
    service_name
    service_charge_amount
    service_quantity
    service_duration

    service_ticket{
        est_duration
        est_distance
        destination
    }

    invoice_id
    invoice_date
}

customer[
    customer_id
    customer_name
    customer_address
    customer_phone
    
    
    customer_type
]


service_vehicale[
    customer_id

    vehicale_ID
    vehicle_type
    vehicle_model
    vehicle_brand

    driver_id
    driver_name
    driver_address
    driver_phone

    service_type_id
    service_name
    service_charge_amount
    service_quantity

    invoice_id
]


customer[
    customer_id
    customer_name
    customer_address
    customer_phone
    
    
    customer_type

]