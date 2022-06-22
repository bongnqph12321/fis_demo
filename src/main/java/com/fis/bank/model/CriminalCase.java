package com.fis.bank.model;


import com.fis.bank.core.CaseStatus;
import com.fis.bank.core.CaseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "criminal")
public class CriminalCase extends  AbstractEntity{
    private String number;

    @Enumerated(EnumType.STRING)
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    //very big text
    private String notes;
    @OneToMany(mappedBy = "criminalCase")
    private Set<Evidence> evidenceSet;
    @ManyToOne
    @JoinColumn(name = "lead_investigator", nullable = false)
    private Detective leadInvestigator;

}
