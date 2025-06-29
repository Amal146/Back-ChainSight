package com.example.chainsight.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "userid", columnDefinition = "UUID")
    private UUID userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(name = "wallet_address", unique = true)
    private String walletAddress;

    @Column(name = "blockchain_type")
    private String blockchainType; // "ethereum", "binance", "hedera", etc.

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    @Column(name = "createdat", nullable = false)
    private LocalDateTime createdAt;

    private boolean isWalletUser; // Flag to distinguish wallet-only users

    // Additional helper methods
    public boolean isWalletLoginEnabled() {
        return walletAddress != null && !walletAddress.isEmpty();
    }

    public boolean isEmailLoginEnabled() {
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email; // or username, depending on your login identifier
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}