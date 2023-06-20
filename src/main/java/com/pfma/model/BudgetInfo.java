package com.pfma.model;

import com.pfma.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "budget_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BudgetInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToMany
    @JoinColumn(name = "user_id", nullable = false)
    private List<User> users;

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


    public void addUser(User user){
        this.users.add(user);
    }
    public void addUsers(List<User> userList){
        this.users.addAll(userList);
    }
    public void deleteUser(User user){
        this.users.remove(user);
    }
    public void deleteUsers(List<User> userList){
        this.users.removeAll(userList);
    }
    public void setRoles(User user, Set<Role> roleNameSet){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BudgetInfo that = (BudgetInfo) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}