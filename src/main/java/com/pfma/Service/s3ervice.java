package com.pfma.Service;

import com.pfma.enums.RoleName;
import com.pfma.model.postgresdb1.Role;
import com.pfma.model.postgresdb1.User;
import com.pfma.repository.postgresdb1.RoleRepository;
import com.pfma.repository.postgresdb1.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;


@Service
public class s3ervice {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void insertData() {

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        user1.setName("John");
        user2.setName("Aska");
        user3.setName("Fill");
        user4.setName("Barbara");
        user5.setName("Tali");
        user1.setId(UUID.randomUUID());
        user2.setId(UUID.randomUUID());
        user3.setId(UUID.randomUUID());
        user4.setId(UUID.randomUUID());
        user5.setId(UUID.randomUUID());
        Role role1 = new Role();
        Role role2 = new Role();
        Role role3 = new Role();
        role1.setName(RoleName.ROLE_ADMIN);
        role2.setName(RoleName.ROLE_OWNER);
        role3.setName(RoleName.ROLE_WITHDRAWER);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);

    }
}
