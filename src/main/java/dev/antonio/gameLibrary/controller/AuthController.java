package dev.antonio.gameLibrary.controller;

import dev.antonio.gameLibrary.dto.AuthDTO;
import dev.antonio.gameLibrary.dto.RegisterDTO;
import dev.antonio.gameLibrary.entity.User;
import dev.antonio.gameLibrary.entity.UserRole;
import dev.antonio.gameLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDTO authDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO) {
        if(this.userRepository.findByUsername(registerDTO.getUsername()) != null) return ResponseEntity.badRequest().build();
        if(this.userRepository.findByEmail(registerDTO.getEmail()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getPassword());

        User newUser = new User(registerDTO.getUsername(), registerDTO.getEmail(), encryptedPassword, UserRole.USER);

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
