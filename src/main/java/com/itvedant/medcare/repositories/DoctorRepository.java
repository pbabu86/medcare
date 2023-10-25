package com.itvedant.medcare.repositories;

import org.springframework.data.repository.CrudRepository;

import com.itvedant.medcare.entities.Doctor;

    
public interface DoctorRepository 
    extends CrudRepository<Doctor, Integer>{
    
}

