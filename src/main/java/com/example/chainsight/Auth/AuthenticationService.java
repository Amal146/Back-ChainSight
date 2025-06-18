package com.example.chainsight.Auth;

import com.example.chainsight.Entity.Role;
import com.example.chainsight.Config.JwtService;
import com.example.chainsight.Entity.User;
import com.example.chainsight.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .walletAddress(request.getWalletAddress())
                .blockchainType(request.getBlockchainType())
                .role(Role.USER)
                .build();

        userRepository.save(user);
        var token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .walletAddress(user.getWalletAddress())
                .authenticationMethod("email")
                .role(user.getRole())
                .build();
    }

    public AuthResponse authenticate(LoginRequest request) {
        if (request.isWalletLogin()) {
            return handleWalletLogin(request);
        } else {
            return handleEmailLogin(request);
        }
    }

    private AuthResponse handleEmailLogin(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        var token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .walletAddress(user.getWalletAddress())
                .authenticationMethod("email")
                .role(user.getRole())
                .build();
    }

    private AuthResponse handleWalletLogin(LoginRequest request) {
        var user = userRepository.findByWalletAddress(request.getWalletAddress())
                .orElseThrow(() -> new IllegalArgumentException("Wallet not registered"));

        // Verify the blockchain type matches if needed
        if (request.getBlockchainType() != null &&
                !request.getBlockchainType().equalsIgnoreCase(user.getBlockchainType())) {
            throw new IllegalArgumentException("Wallet blockchain mismatch");
        }

        var token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .walletAddress(user.getWalletAddress())
                .authenticationMethod("wallet")
                .role(user.getRole())
                .build();
    }
}