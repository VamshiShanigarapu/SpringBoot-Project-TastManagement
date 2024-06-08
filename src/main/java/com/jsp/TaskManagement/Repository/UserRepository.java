package com.jsp.TaskManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.TaskManagement.Entity.Users;


public interface UserRepository extends JpaRepository<Users, Long> {

}
