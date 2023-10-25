package com.itvedant.medcare.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.itvedant.medcare.entities.User;
import com.itvedant.medcare.entities.UserWithoutPassword;


@RepositoryRestResource(excerptProjection = UserWithoutPassword.class)
public interface UserRepository 
    extends JpaRepository<User, Integer>{

    List<User> findByFirstName(String name);

    //select * from user where email = ?
    User findByEmail(String email);

    //select * from user where email like '%e%'
    List<User> findByEmailContaining(String pattern);

}
    