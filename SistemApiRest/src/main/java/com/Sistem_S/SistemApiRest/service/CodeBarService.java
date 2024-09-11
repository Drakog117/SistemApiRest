package com.Sistem_S.SistemApiRest.service;

import com.Sistem_S.SistemApiRest.repository.CodeBarRepository;
import com.Sistem_S.SistemApiRest.dto.CodeBarRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CodeBarService {

    private final CodeBarRepository codeBarRepository;

    public void storeBarCode(CodeBarRequest codeBarRequest) {
        // Aquí puedes agregar lógica adicional si es necesario
        String NameBarCode = codeBarRequest.getNameBarCode();
        Integer idUser = codeBarRequest.getIdUser();

        // Llama al repositorio para ejecutar el procedimiento almacenado
        codeBarRepository.storeBarCode(NameBarCode, idUser);
    }
}
