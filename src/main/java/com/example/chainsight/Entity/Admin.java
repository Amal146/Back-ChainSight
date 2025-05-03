package com.example.chainsight.Entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Admin {
    @Id
    private UUID id;

    @ElementCollection
    private List<String> privileges;

    @OneToMany(mappedBy = "admin")
    private List<ComplianceRule> complianceRules;

    public Admin(UUID id, List<String> privileges, List<ComplianceRule> complianceRules) {
        this.id = id;
        this.privileges = privileges;
        this.complianceRules = complianceRules;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<String> privileges) {
        this.privileges = privileges;
    }

    public List<ComplianceRule> getComplianceRules() {
        return complianceRules;
    }

    public void setComplianceRules(List<ComplianceRule> complianceRules) {
        this.complianceRules = complianceRules;
    }
}

