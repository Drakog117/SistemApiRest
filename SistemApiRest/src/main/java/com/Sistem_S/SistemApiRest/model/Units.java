package com.Sistem_S.SistemApiRest.model;

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
public class Units {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer IdUnit;
    @Basic
    String  NameUnit;
}
