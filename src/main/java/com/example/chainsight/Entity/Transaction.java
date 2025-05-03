package com.example.chainsight.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Transaction {
    @Id
    private String txHash;
    private String fromAddress;
    private String toAddress;
    private Float value;
    private String token;
    private LocalDateTime timestamp;
    private String category;
    private Float gasUsed;
    private Boolean isSuspicious;

    @ManyToOne
    private Wallet wallet;

    @ManyToMany(mappedBy = "transactions")
    private List<TaxReport> taxReports;

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(Float gasUsed) {
        this.gasUsed = gasUsed;
    }

    public Boolean getSuspicious() {
        return isSuspicious;
    }

    public void setSuspicious(Boolean suspicious) {
        isSuspicious = suspicious;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public List<TaxReport> getTaxReports() {
        return taxReports;
    }

    public void setTaxReports(List<TaxReport> taxReports) {
        this.taxReports = taxReports;
    }

    public Transaction(String txHash, String fromAddress, String toAddress, Float value, String token, LocalDateTime timestamp, String category, Float gasUsed, Boolean isSuspicious, Wallet wallet, List<TaxReport> taxReports) {
        this.txHash = txHash;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.value = value;
        this.token = token;
        this.timestamp = timestamp;
        this.category = category;
        this.gasUsed = gasUsed;
        this.isSuspicious = isSuspicious;
        this.wallet = wallet;
        this.taxReports = taxReports;
    }
}