package com.rpg.web.rpg_web.controllers;

// import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.web.rpg_web.infra.dto.UserRequestDTO;
import com.rpg.web.rpg_web.services.ServiceCadastro;


@RestController
@RequestMapping("/register")
public class ControllerCadastro {

    private ServiceCadastro service;

    public ControllerCadastro(ServiceCadastro service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserRequestDTO body) {
        return service.register(body);
    }
}
