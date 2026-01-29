package com.rpg.web.rpg_web.infra.domain;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UsersDomain {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    
    private String email;

    private String password;

    private boolean active;

}
