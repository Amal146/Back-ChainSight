package com.example.chainsight.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Blockchain {
    @Id
    private String chainId;
    private String name;
    private String explorerURL;

    @OneToMany(mappedBy = "blockchain")
    private List<Wallet> wallets;

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplorerURL() {
        return explorerURL;
    }

    public void setExplorerURL(String explorerURL) {
        this.explorerURL = explorerURL;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    public Blockchain(String chainId, String name, String explorerURL, List<Wallet> wallets) {
        this.chainId = chainId;
        this.name = name;
        this.explorerURL = explorerURL;
        this.wallets = wallets;
    }
}
