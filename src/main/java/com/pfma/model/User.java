package com.pfma.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 15, message = "Username should be between 5 and 15 characters")
    private String username;

    @Column(nullable = false)
    @NotNull
    private String password;

    @Column(nullable = false)
    @Email
    private String email;

    @ManyToMany(mappedBy = "user")
    private Set<BudgetInfo> budgetInfo = new HashSet<>();


}