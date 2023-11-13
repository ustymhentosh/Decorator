package com.example.flower.control;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.flower.users.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    @Query("SELECT u FROM AppUser u WHERE u.email = :email")
    Optional<AppUser> findUserByEmail(@Param("email") String email);
}
