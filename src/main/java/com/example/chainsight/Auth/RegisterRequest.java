package com.example.chainsight.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Username is required")
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String walletAddress;
    private String blockchainType;
    private String otherBlockchain; // Only used when blockchainType is "other"
    private boolean rememberMe;
}