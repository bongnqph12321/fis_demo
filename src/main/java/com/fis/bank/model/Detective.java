package com.fis.bank.model;

import com.fis.bank.core.EmploymentStatus;
import com.fis.bank.core.Rank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detective")
public class Detective extends AbstractEntity {
    private String badgeNumber;
    @Column(name = "rank_detective")
    @Enumerated(EnumType.STRING)
    private Rank rank;
    private Boolean armed = false;
    @Column(name = "status_detective")
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status = EmploymentStatus.ACTIVE;
    //private Set<CriminalCase> criminalCases = new HashSet<>();
    @OneToMany(mappedBy = "detective",fetch = FetchType.EAGER)
    private Set<TrackEntry> trackEntries;


}
