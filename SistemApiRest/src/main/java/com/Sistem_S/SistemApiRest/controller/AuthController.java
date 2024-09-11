package com.Sistem_S.SistemApiRest.controller;

import com.Sistem_S.SistemApiRest.Jwt.AuthResponse;
import com.Sistem_S.SistemApiRest.Jwt.AuthService;
import com.Sistem_S.SistemApiRest.dto.LoginRequest;
import com.Sistem_S.SistemApiRest.dto.RegisterRequest;
import com.Sistem_S.SistemApiRest.dto.CodeBarRequest;
import com.Sistem_S.SistemApiRest.dto.UsersRequest;
import com.Sistem_S.SistemApiRest.service.CodeBarService;
import com.Sistem_S.SistemApiRest.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserDetailsService userDetailsService;
    private final CodeBarService codeBarService;
    private final UsersService usersService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Que quieres coimer?");
    }

    @PostMapping("/storeCodeBar")
    public ResponseEntity<String> setCodeBarRepository(@RequestBody CodeBarRequest codeBarRequest) {
        try {
            // Llama al servicio para manejar la solicitud
            codeBarService.storeBarCode(codeBarRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Código de barras guardado con éxito");
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el stack trace del error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el código de barras");
        }
    }

    @PostMapping("/Users")
    public ResponseEntity<String> setCodeBarRepository(@RequestBody UsersRequest UsersRequest) {
        try {
            // Llama al servicio para manejar la solicitud
            usersService.CatalogUsers(UsersRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Se consulto el catalogo");
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el stack trace del error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al consultar");
        }
    }
}