package com.Sistem_S.SistemApiRest.Jwt;

import com.Sistem_S.SistemApiRest.dto.LoginRequest;
import com.Sistem_S.SistemApiRest.dto.RegisterRequest;
import com.Sistem_S.SistemApiRest.model.Role;
import com.Sistem_S.SistemApiRest.model.SystemUsers;
import com.Sistem_S.SistemApiRest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        SystemUsers systemUsers = SystemUsers.builder()
                .username(request.getUsername())
                .full_name(request.getFull_name())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(Role.USER)
                .build();

        userRepository.save(systemUsers);

        return AuthResponse.builder()
                .token(jwtService.getToken(systemUsers))
                .build();
    }

}