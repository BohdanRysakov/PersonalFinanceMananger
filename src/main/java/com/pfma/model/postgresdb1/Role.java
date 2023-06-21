package com.pfma.model.postgresdb1;

import com.pfma.enums.RoleName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "role",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"name"}))
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;


}
