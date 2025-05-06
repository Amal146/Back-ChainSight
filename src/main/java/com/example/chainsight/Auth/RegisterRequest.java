package com.example.chainsight.Auth;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String walletAddress;
    private String blockchainType;
    private String otherBlockchain; // Only used when blockchainType is "other"
    private boolean rememberMe;
}