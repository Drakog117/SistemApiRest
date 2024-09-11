package com.Sistem_S.SistemApiRest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UnitsRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UnitsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // MEtodo para llamar al procedimiento almacenado y extraer un valor

    public String getUnitName(Integer idUser) {
        System.out.println("Executing getUnitName with parameters: " + idUser);
        String sql = "{call Catalog_Units(?)}";

        // Usa queryForObject para ejecutar el procedimiento y obtener un único valor
        return jdbcTemplate.queryForObject(sql, new Object[]{idUser}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                // Asegúrate de que el nombre de la columna coincida con el de tu procedimiento almacenado
                return rs.getString("NameUnit");
            }
        });
    }
}
