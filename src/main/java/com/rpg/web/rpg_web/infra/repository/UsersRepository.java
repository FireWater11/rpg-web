package com.rpg.web.rpg_web.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


// <Classe referente, tipo da PK>
public interface UsersRepository extends JpaRepository<UsersRepository, UUID> {
    boolean existsByEmail(String email);
}
