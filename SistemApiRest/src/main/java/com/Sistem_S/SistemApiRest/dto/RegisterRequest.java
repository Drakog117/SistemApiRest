package com.Sistem_S.SistemApiRest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String  username;
    String  full_name;
    String  password;
    String  phone;
}
