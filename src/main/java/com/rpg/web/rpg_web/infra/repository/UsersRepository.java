package com.rpg.web.rpg_web.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpg.web.rpg_web.infra.domain.UsersDomain;


// <Classe referente, tipo da PK>
public interface UsersRepository extends JpaRepository<UsersDomain, UUID> {
    boolean existsByEmail(String email);
}
