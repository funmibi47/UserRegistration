package com.userreg.web.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userreg.web.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
