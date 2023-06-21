package com.pfma.model.postgresdb1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "budget",uniqueConstraints=
@UniqueConstraint(columnNames={"budgetName"}))
public class Budget {
    @Id
    private UUID id;
    @Column
    private String budgetName;
    @Column
    private String currentCash;
    @Column
    private String description;
    @Column
    private String deductMoneyLimit;
    @Column
    private String accrueMoneyLimit;
    @Column
    private boolean deductMoneyOperation;
    @Column
    private boolean accrueMoneyOperation;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "budget")
    private List<Operation> operations;


}
