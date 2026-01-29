package com.rpg.web.rpg_web.services;

import org.springframework.http.ResponseEntity;

import com.rpg.web.rpg_web.infra.dto.UserDTO;

public class ServiceCadastro {

    public ResponseEntity<String> register(UserDTO body) {
        
        if (body.getUsername() == null || body.getUsername().isBlank() || 
        body.getEmail() == null || 
        body.getEmail().isBlank() || 
        body.getPassword() == null || body.getPassword().isBlank()) {
            // Para retornar um Status HTTP: ResponseEntity.(nome do status).(se vai retornar algo no body)
            return ResponseEntity.badRequest().body("Informações obrigatorias.");
        }

        


    }
    
}
