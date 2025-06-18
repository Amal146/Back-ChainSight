package com.example.chainsight.Repository;

import com.example.chainsight.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    // Fix: change findByUserId to use user.userId
    List<Wallet> findByUser_userId(UUID userId); // This will correctly query based on User's userId
}
