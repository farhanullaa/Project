package com.example.firstapi.demo.crudspring.survey.SpringJPAuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Long>{

}