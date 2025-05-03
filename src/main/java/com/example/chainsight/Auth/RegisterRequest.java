// RegisterRequest.java
package com.example.chainsight.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;

    public CharSequence getPassword() {
    }

    public Object getUsername() {
    }
}