package com.itvedant.medcare.entities;

import java.time.Instant;
//import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String doctorName;

    private String patientName;

    private String medicineList;

    @CreatedDate
    @Column(updatable = false)
    private Instant creationTime;
    @LastModifiedDate
    private Instant updateTime;

    //@ManyToMany(mappedBy ="medicine")
    //private List<Medicine> medicines;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    //@ManyToOne(mappedBy ="doctor")
    //private List<Patient> patients;
}
