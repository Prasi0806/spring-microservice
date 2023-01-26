package com.prasi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prasi.user.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
