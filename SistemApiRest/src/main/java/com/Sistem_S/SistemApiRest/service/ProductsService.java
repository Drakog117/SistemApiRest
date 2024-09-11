package com.Sistem_S.SistemApiRest.service;

import com.Sistem_S.SistemApiRest.repository.ProductsRepository;
import com.Sistem_S.SistemApiRest.dto.ProductsRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public void storeProducts(ProductsRequest productsRequest) {
        // Aquí puedes agregar lógica adicional si es necesario
        String  NameProduct  = productsRequest.getNameProduct();
        Integer PriceProduct = productsRequest.getPriceProduct();
        Integer idUnit       = productsRequest.getIdUnit();
        Integer idUser       = productsRequest.getIdUser();

        // Llama al repositorio para ejecutar el procedimiento almacenado
        productsRepository.storeProducts(NameProduct,PriceProduct,idUnit, idUser);
    }

}
