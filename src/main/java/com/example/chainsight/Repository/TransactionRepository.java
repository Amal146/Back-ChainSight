package com.example.chainsight.Repository;

import com.example.chainsight.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByWalletWalletId(UUID walletId); // Correct method
}
