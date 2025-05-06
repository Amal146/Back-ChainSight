// UserRepository.java
package com.example.chainsight.Repository;


import com.example.chainsight.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByWalletAddress(String walletAddress);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

}