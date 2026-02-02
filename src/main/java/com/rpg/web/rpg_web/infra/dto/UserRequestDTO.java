package com.rpg.web.rpg_web.infra.dto;

import lombok.Data;

@Data

public class UserRequestDTO {
    private String username;
    private String email;
    private String password;
}
