package com.rpg.web.rpg_web.controllers;

// import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.web.rpg_web.infra.dto.UserDTO;
import com.rpg.web.rpg_web.services.ServiceCadastro;

@RestController
@RequestMapping("/register")
public class ControllerCadastro {

    private ServiceCadastro service;

    public ControllerCadastro(ServiceCadastro service) {
        this.service = service;
    }

    public void/*List<Users>*/ register(@RequestBody UserDTO body) {
        service.register(body);
    }


}
