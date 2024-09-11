package com.Sistem_S.SistemApiRest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;


@Repository
public class UsersRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public void CatalogUsers(Integer id) {
        System.out.println("Executing storeBarCode with parameters: " + id );
        jdbcTemplate.update(
                "{call Catalog_Users(?)}",
                new Object[]{id},
                new int[]{Types.INTEGER}
        );
    }
}