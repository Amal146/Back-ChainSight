package com.example.chainsight.Entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Wallet {
    @Id
    private UUID walletId;
    private String address;
    private String label;

    @ManyToOne
    private Blockchain blockchain;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "wallet")
    private List<Transaction> transactions;

    public UUID getWalletId() {
        return walletId;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Wallet(UUID walletId, String address, String label, Blockchain blockchain, User user, List<Transaction> transactions) {
        this.walletId = walletId;
        this.address = address;
        this.label = label;
        this.blockchain = blockchain;
        this.user = user;
        this.transactions = transactions;
    }
}


