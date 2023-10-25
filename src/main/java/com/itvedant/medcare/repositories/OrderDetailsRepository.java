package com.itvedant.medcare.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itvedant.medcare.entities.OrderDetails;


@RestResource(path = "orderdetails")
public interface OrderDetailsRepository 
    extends JpaRepository<OrderDetails,Integer>{
    
}