package com.itvedant.medcare.repositories;

import org.springframework.data.repository.CrudRepository;

import com.itvedant.medcare.entities.Prescription;

    
public interface PrescriptionRepository 
    extends CrudRepository<Prescription, Integer>{
    
}

