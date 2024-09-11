package com.Sistem_S.SistemApiRest.service;

import com.Sistem_S.SistemApiRest.dto.UsersRequest;
import com.Sistem_S.SistemApiRest.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository; // Corrige el nombre del campo

    public void CatalogUsers(UsersRequest usersRequest) {
        // Aquí puedes agregar lógica adicional si es necesario
        Integer id = usersRequest.getIds(); // Accede a getIds() desde la instancia

        // Llama al repositorio para ejecutar el procedimiento almacenado
        usersRepository.CatalogUsers(id); // Llama al método a través del objeto usersRepository
    }
}
