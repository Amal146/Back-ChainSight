package com.example.chainsight.Service;


import com.example.chainsight.Entity.Wallet;
import com.example.chainsight.Repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Optional<Wallet> getWalletById(UUID id) {
        return walletRepository.findById(id);
    }

    public List<Wallet> getWalletsByUserId(UUID userId) {
        return walletRepository.findByUser_userId(userId);
    }

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public void deleteWallet(UUID id) {
        walletRepository.deleteById(id);
    }
}

