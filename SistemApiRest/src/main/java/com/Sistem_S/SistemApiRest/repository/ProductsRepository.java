package com.Sistem_S.SistemApiRest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;


@Repository
public class ProductsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storeProducts(String NameProduct, Integer PriceProduct, Integer idUnit, Integer idUser) {
        System.out.println("Executing storeBarCode with parameters: " + NameProduct + ", " + PriceProduct + ", " + idUnit + ", " + idUser);
        jdbcTemplate.update(
                "{call Store_Products(?, ?, ?, ?)}",
                new Object[]{NameProduct,PriceProduct,idUnit, idUser},
                new int[]{Types.VARCHAR, Types.INTEGER,Types.INTEGER,Types.INTEGER}
        );
    }
}