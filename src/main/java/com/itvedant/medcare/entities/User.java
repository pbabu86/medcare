package com.itvedant.medcare.entities;

import java.time.Instant;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "First Name is required")
    @NotEmpty(message = "First Name is empty")
    @Column(name = "fname", nullable = false)
    private String firstName;

    @NotEmpty(message = "Last Name is empty")
    @Column(name = "lname", nullable =false)
    private String lastName;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is empty")
    @Email(message = "Email is not well formed")
    @Column(unique = true)
    private String email;

    //Custom Validation
    //Mobile should have 10 characters
    //and all the characters should be numbers
    @Mobile
    private String mobile;
    private String password;

    @Transient
    private String confirmPassword;   

    @CreatedDate
    private Instant creationTime;

    @LastModifiedDate
    private Instant updationTime;

    
    @OneToOne
    @JoinColumn(name = "addr_id")
    private Address userAddress;
}
