package com.pfma.repository.postgresdb1;

import com.pfma.model.postgresdb1.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
