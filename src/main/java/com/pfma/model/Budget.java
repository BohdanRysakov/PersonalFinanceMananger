package com.pfma.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "budgets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private Double totalIncome;

    @Column(nullable = false)
    private Double totalExpense;

    @OneToOne
    @JoinColumn(name = "budget_info_id", nullable = false)
    private BudgetInfo BudgetInfo;


}