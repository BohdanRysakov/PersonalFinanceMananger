package com.pfma;

import com.pfma.model.postgresdb1.Role;
import com.pfma.model.postgresdb1.User;
import com.pfma.repository.postgresdb1.RoleRepository;
import com.pfma.repository.postgresdb1.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableJpaAuditing
public class PersonalFinanceManagementApplication {


    public static void main(String[] args) {
        SpringApplication.run(PersonalFinanceManagementApplication.class, args);





    }


}
