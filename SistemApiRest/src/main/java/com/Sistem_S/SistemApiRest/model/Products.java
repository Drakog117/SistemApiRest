package com.Sistem_S.SistemApiRest.model;

import com.Sistem_S.SistemApiRest.model.Units;
import com.Sistem_S.SistemApiRest.model.SystemUsers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer IdProduct;
    @Basic
    String  NameProduct;
    Integer PriceProduct;
    @ManyToOne
    @JoinColumn(name = "idUnit", referencedColumnName = "IdUnit")
    private Units units;
    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private SystemUsers user;
}
