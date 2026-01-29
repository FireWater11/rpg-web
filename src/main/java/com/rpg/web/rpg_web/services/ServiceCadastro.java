package com.rpg.web.rpg_web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rpg.web.rpg_web.infra.domain.UsersDomain;
import com.rpg.web.rpg_web.infra.dto.UserDTO;
import com.rpg.web.rpg_web.infra.repository.UsersRepository;

@Service

public class ServiceCadastro {

    @Autowired
    private UsersRepository user;
    // NÃO PODE ESTAR DENTRO DE UM METODO

    public ResponseEntity<String> register(UserDTO body) {

        try {
            if (body.getUsername() == null || body.getUsername().isBlank() || 
            body.getEmail() == null || body.getEmail().isBlank() || 
            body.getPassword() == null || body.getPassword().isBlank()) {
                // Para retornar um Status HTTP: ResponseEntity.(nome do status).(se vai retornar algo no body)
                return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body("Informações obrigatorias.");
            }

            // tipo um SELECT, porém o Spring gerencia tudo sozinho
            if (user.existsByEmail(body.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado.");
            }

            if (Integer.parseInt(body.getPassword()) < 8) {
                return ResponseEntity.status(
                    HttpStatus.LENGTH_REQUIRED).body("Senha deve no mínimo 8 caracteres");
            }

            UsersDomain novoUsuario = new UsersDomain(
                null,
                body.getUsername(),
                body.getEmail(),
                body.getPassword(),
                true
            );

            // fazer a persistencia
            // retornar para o FE que o usuario foi criado
            // Criptografar a senha

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor: " +e);
        }
    }  
}
