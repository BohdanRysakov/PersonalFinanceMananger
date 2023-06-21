package com.pfma.model.postgresdb1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users",uniqueConstraints=
@UniqueConstraint(columnNames={"name", "email"})
)
@Setter
@Getter
public class User {
    @Id
    private UUID id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String password;

    @Column
    @Email
    private String email;

    @Column
    @Lob
    private byte[] image;

    @OneToMany(mappedBy = "user")
    private List<Operation> operations;



}
