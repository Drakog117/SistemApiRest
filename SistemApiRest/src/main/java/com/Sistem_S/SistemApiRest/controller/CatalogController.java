package com.Sistem_S.SistemApiRest.controller;

import com.Sistem_S.SistemApiRest.dto.UsersRequest;
import com.Sistem_S.SistemApiRest.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Catalog")
@RequiredArgsConstructor
public class CatalogController {

        private final UsersService usersService;

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

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Que quieres coimer?");
    }

}
