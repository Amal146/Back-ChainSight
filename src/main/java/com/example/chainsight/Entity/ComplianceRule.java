package com.example.chainsight.Entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class ComplianceRule {
    @Id
    private UUID ruleId;
    private String jurisdiction;
    private String ruleLogic;

    @ManyToOne
    private Admin admin;

    public UUID getRuleId() {
        return ruleId;
    }

    public void setRuleId(UUID ruleId) {
        this.ruleId = ruleId;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getRuleLogic() {
        return ruleLogic;
    }

    public void setRuleLogic(String ruleLogic) {
        this.ruleLogic = ruleLogic;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ComplianceRule(UUID ruleId, String jurisdiction, String ruleLogic, Admin admin) {
        this.ruleId = ruleId;
        this.jurisdiction = jurisdiction;
        this.ruleLogic = ruleLogic;
        this.admin = admin;
    }
}

