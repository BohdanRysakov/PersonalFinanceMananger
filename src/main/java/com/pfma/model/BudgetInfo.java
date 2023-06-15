package com.pfma.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "budget_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "budget_id", nullable = false)
    private Budget budget;

    @ManyToMany
    @JoinColumn(name = "role_id", nullable = false)
    private List<Role> role;

    @Column(nullable = false)
    private double spendingLimit = 0;
    @Column(nullable = false)
    private double buyingLimit = 0;
    @Column(nullable = false)
    private boolean isSpendingAllowed = false;
    @Column(nullable = false)
    private boolean isBuyingAllowed = false;
    @Column(nullable = false)
    private boolean budgetViewAllowed = true;

    @Column(nullable = false)
    private boolean deletionAllowed = false;

    @Column(nullable = false)
    private boolean changingAllowed = true;
}