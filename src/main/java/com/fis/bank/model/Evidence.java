package com.fis.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evidence")
public class Evidence extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "criminal_case_id")
    private CriminalCase criminalCase;
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
    private String number;
    private String itemName;
    //very big text
    private String notes;
    private Boolean archived = false;
    @OneToMany(mappedBy = "evidence")
    private Set<TrackEntry> trackEntries = new HashSet<>();


}
