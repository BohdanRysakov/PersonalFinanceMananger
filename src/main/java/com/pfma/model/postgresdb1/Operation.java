package com.pfma.model.postgresdb1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "operations")
public class Operation {

    @Id
    private UUID id;

    @Column
    private String description;
    @Column
    private double cashAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}