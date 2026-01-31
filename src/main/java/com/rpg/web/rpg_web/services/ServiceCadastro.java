package com.rpg.web.rpg_web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rpg.web.rpg_web.infra.domain.UsersDomain;
import com.rpg.web.rpg_web.infra.dto.UserRequestDTO;
import com.rpg.web.rpg_web.infra.dto.UserResponseDTO;
import com.rpg.web.rpg_web.infra.repository.UsersRepository;

@Service

public class ServiceCadastro {

    

    @Autowired
    private UsersRepository repository;
    // NÃO PODE ESTAR DENTRO DE UM METODO

    @Autowired
    private BCryptPasswordEncoder encoder;

    public ResponseEntity<?> register(UserRequestDTO body) {

        try {
            if (body.getUsername() == null || body.getUsername().isBlank() || 
            body.getEmail() == null || body.getEmail().isBlank() || 
            body.getPassword() == null || body.getPassword().isBlank()) {
                // Para retornar um Status HTTP: ResponseEntity.(nome do status).(se vai retornar algo no body)
                return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body("Informações obrigatorias.");
            }

            // tipo um SELECT, porém o Spring gerencia tudo sozinho
            if (repository.existsByEmail(body.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado.");
            }

            if (body.getPassword().length() < 8) {
                return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body("Senha deve tamanho mínimo de 8 caracteres");
            }

            String passwordHash = encoder.encode(body.getPassword());

            UsersDomain novoUsuario = new UsersDomain(
                null,
                body.getUsername(),
                body.getEmail(),
                passwordHash,
                true
            );

            UsersDomain saveUser = repository.save(novoUsuario);

            UserResponseDTO response = new UserResponseDTO(
                saveUser.getId(),
                saveUser.getUsername(),
                saveUser.getEmail()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

            // retornar se está ativo
            // retornar sempre JSON

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor: " +e);
        }
    }  
}
