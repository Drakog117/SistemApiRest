package com.Sistem_S.SistemApiRest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
public class CodeBarRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CodeBarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storeBarCode(String nameBarCode, Integer idUser) {
        System.out.println("Executing storeBarCode with parameters: " + nameBarCode + ", " + idUser);
        jdbcTemplate.update(
                "{call Store_BarCode(?, ?)}",
                new Object[]{nameBarCode, idUser},
                new int[]{Types.VARCHAR, Types.INTEGER}
        );
    }
}
