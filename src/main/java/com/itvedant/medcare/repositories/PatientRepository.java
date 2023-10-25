package com.itvedant.medcare.repositories;

import org.springframework.data.repository.CrudRepository;

import com.itvedant.medcare.entities.Patient;


public interface PatientRepository
    extends CrudRepository<Patient, Integer>{
    
}
