package com.example.chainsight.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class TaxReport {
    @Id
    private UUID reportId;
    private UUID userId;
    private Date generatedAt;
    private Float totalGain;
    private Float totalLoss;

    @ManyToMany
    @JoinTable(
            name = "taxreport_transaction",
            joinColumns = @JoinColumn(name = "report_id"),
            inverseJoinColumns = @JoinColumn(name = "tx_hash")
    )
    private List<Transaction> transactions;

    @ManyToOne
    private User user;

    public UUID getReportId() {
        return reportId;
    }

    public void setReportId(UUID reportId) {
        this.reportId = reportId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Date getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Date generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Float getTotalGain() {
        return totalGain;
    }

    public void setTotalGain(Float totalGain) {
        this.totalGain = totalGain;
    }

    public Float getTotalLoss() {
        return totalLoss;
    }

    public void setTotalLoss(Float totalLoss) {
        this.totalLoss = totalLoss;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaxReport(UUID reportId, UUID userId, Date generatedAt, Float totalGain, Float totalLoss, List<Transaction> transactions, User user) {
        this.reportId = reportId;
        this.userId = userId;
        this.generatedAt = generatedAt;
        this.totalGain = totalGain;
        this.totalLoss = totalLoss;
        this.transactions = transactions;
        this.user = user;
    }
}

