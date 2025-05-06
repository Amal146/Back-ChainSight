package com.example.chainsight.Auth;

import com.example.chainsight.Entity.Role;
import lombok.*;

@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String email;
    private String walletAddress;
    private String authenticationMethod; // "email" or "wallet"
    private Role role;

}
