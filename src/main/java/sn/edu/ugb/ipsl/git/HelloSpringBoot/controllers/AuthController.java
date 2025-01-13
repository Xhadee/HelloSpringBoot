package sn.edu.ugb.ipsl.git.HelloSpringBoot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity login() {
        return ResponseEntity.ok().body("login successful");
    }

    @GetMapping("/logout")
    public ResponseEntity logout() {
        return ResponseEntity.ok().body("logout successful");
    }
}
