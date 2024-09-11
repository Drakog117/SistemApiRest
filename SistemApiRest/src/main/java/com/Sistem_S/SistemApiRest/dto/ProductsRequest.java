package com.Sistem_S.SistemApiRest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRequest {
    String NameProduct;
    Integer PriceProduct;
    Integer idUnit;
    Integer IdUser;
}
