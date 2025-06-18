package com.example.chainsight.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
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

    public Wallet(UUID walletId, String address, String label, Blockchain blockchain, User user, List<Transaction> transactions) {
        this.walletId = walletId;
        this.address = address;
        this.label = label;
        this.blockchain = blockchain;
        this.user = user;
        this.transactions = transactions;
    }
}


