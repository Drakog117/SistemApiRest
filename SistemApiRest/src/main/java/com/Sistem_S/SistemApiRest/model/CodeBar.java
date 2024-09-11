package com.Sistem_S.SistemApiRest.model;

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
public class CodeBar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer IdCode;
    @Basic
    String NameBarCode;
    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private SystemUsers user;
}
