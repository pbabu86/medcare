package com.itvedant.medcare.entities;

import java.time.Instant;
import java.util.List;

import org.hibernate.validator.constraints.Length;
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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Name should not be null")
    @NotEmpty(message = "Name Should contain data")
    @Length(min =3, max = 20, message = "Name should be of 3 to 20 character")
    private String name;

    @NotNull(message = "Price should not be null")
    @Min(value = 1, message = "Price should not be less than 1")
    @Max(value = 10000, message = "Price should not be greater than 10000")
    private Double price;

    @NotNull(message = "Description should not be null")
    @NotEmpty(message = "Description Should contain data")
    @Length(min =10, max = 200, message = "Description should be of 10 to 200 character")
    private String description;

    private Integer Qty;

    @CreatedDate
    @Column(updatable = false)
    private Instant creationTime;

    @LastModifiedDate
    private Instant updationTime;

    //@ManyToMany
    //@JoinColumn(name="prescription_id")
    //private Prescription prescription;

    //@ManyToOne
    //@JoinColumn(name="patient_id")
    //private Patient patient;

    @ManyToMany
    @JoinTable(name = "medicine_orders",
                joinColumns = @JoinColumn(name="medicine_id"),
                inverseJoinColumns = @JoinColumn(name="order_id"))
    private List<OrderDetails> orders;

    private String imageUrl;
    
}

