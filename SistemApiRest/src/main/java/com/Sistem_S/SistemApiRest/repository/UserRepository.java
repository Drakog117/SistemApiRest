package com.Sistem_S.SistemApiRest.repository;

import com.Sistem_S.SistemApiRest.model.SystemUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <SystemUsers, Long> {
    Optional<SystemUsers> findByUsername(String username);
}
