package com.itvedant.medcare.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itvedant.medcare.entities.Medicine;

import java.util.List;


public interface MedicineRepository 
    extends JpaRepository<Medicine, Integer>{

    //select * from product where price = 900;
    List<Medicine> findByPrice(Double price);

    //select * from product where price > 900;
    @RestResource(path = "pricegreater")
    List<Medicine> findByPriceGreaterThan(Double price);

    //select * from product where price < 900;
    @RestResource(path = "priceless")
    List<Medicine> findByPriceLessThan(Double price);

    
    List<Medicine> findByPriceBetween(Double low, Double high);
}
