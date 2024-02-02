package dev.antonio.gameLibrary.dto;

import dev.antonio.gameLibrary.entity.UserRole;
import lombok.Data;

@Data
public class RegisterDTO {
    private String username;
    private String email;
    private String password;
    private UserRole role;
}
