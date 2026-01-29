package com.rpg.web.rpg_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.web.rpg_web.services.ServiceCadastro;

@RestController
@RequestMapping("/register")
public class ControllerCadastro {

    private ServiceCadastro service;

    public ControllerCadastro(ServiceCadastro service) {
        this.service = service;
    }

    


}
