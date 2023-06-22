package com.pfma.model.postgresdb1;

import com.pfma.abstraction.AppUserDetails;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users",uniqueConstraints=
@UniqueConstraint(columnNames={"name", "email"})
)
@Setter
@Getter
public class User implements AppUserDetails {
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

    @ManyToMany(mappedBy = "users")
    private List<Budget> budgets;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getUsername() {
        return name;
    }
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    @Override
    public boolean isEnabled() {
        return false;
    }
}
