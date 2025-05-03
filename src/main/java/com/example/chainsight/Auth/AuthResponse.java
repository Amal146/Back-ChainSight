// AuthResponse.java
package com.example.chainsight.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
    }
}
