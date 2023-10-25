package com.itvedant.medcare.entities;

import java.time.Instant;
//import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.itvedant.medcare.validators.Mobile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String prescription;
    @Mobile
    private String mobile;

    @CreatedDate
    @Column(updatable = false)
    private Instant creationTime;
    @LastModifiedDate
    private Instant updateTime;

    //@OneToMany(mappedBy = "doctor")
    //private List<Medicine> medicines;
}
