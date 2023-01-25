package com.nobile.realing.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nobile.realing.entity.User;

public interface UserRepository extends CrudRepository<User,Long>{

    Optional<User> findByEmail(String email);

}
