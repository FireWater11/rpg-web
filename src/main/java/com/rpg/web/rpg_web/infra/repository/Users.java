package com.rpg.web.rpg_web.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


// <Classe referente, tipo da PK>
public interface Users extends JpaRepository<Users, UUID> {

}
