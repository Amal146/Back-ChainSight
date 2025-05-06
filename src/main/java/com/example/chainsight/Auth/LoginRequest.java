package com.example.chainsight.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    // For email/password login
    private String email;
    private String password;

    // For wallet login
    private String walletAddress;
    private String blockchainType; // "ethereum", "binance", etc.

    // Common fields
    private boolean rememberMe;

    // Helper method to check if this is a wallet login request
    public boolean isWalletLogin() {
        return walletAddress != null && !walletAddress.isEmpty();
    }

    // Helper method to check if this is an email/password login request
    public boolean isEmailPasswordLogin() {
        return email != null && !email.isEmpty() &&
                password != null && !password.isEmpty();
    }
}