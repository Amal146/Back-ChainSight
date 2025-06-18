package com.example.chainsight.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Transaction {
    @Setter
    @Getter
    @Id
    private String txHash;
    @Setter
    private String token;
    @Getter
    private LocalDateTime timestamp;
    @Setter
    private Float gasUsed;
    private Boolean isSuspicious;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Boolean getSuspicious() {
        return isSuspicious;
    }

    public void setSuspicious(Boolean suspicious) {
        isSuspicious = suspicious;
    }

    public Transaction(String txHash, String fromAddress, String toAddress, Float value, String token, LocalDateTime timestamp, String category, Float gasUsed, Boolean isSuspicious, Wallet wallet, List<TaxReport> taxReports) {
        this.txHash = txHash;
        this.token = token;
        this.timestamp = timestamp;
        this.gasUsed = gasUsed;
        this.isSuspicious = isSuspicious;
        this.wallet = wallet;
    }
}