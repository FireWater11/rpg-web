package com.rpg.web.rpg_web.infra.dto;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String username,
        String email
) {

    
}
