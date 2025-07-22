package com.cbase.userregistration.configuration.repository;

import com.cbase.userregistration.configuration.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findById(Integer id);

    @Transactional
    void deleteById(Integer id);

}
