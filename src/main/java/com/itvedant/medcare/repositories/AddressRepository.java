package com.itvedant.medcare.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.medcare.entities.Address;


public interface AddressRepository 
    extends JpaRepository<Address, Integer>{
    
}
