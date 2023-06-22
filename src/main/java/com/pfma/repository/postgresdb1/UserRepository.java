package com.pfma.repository.postgresdb1;

import com.pfma.model.postgresdb1.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(value = "SELECT u.id FROM users u WHERE u.name = ?1", nativeQuery = true)
    UUID findUserIdByUsername(String name);
    @Query(value = "SELECT u.name FROM users u WHERE u.id = ?1", nativeQuery = true)
    UUID findUserNameById(UUID id);
}
