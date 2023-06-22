package com.pfma.Service;

import com.pfma.abstraction.AppUserDetails;
import com.pfma.exceptions.ForbiddenOperation;
import com.pfma.exceptions.UserNotFoundException;
import com.pfma.model.postgresdb1.Budget;
import com.pfma.model.postgresdb1.User;
import com.pfma.repository.postgresdb1.BudgetRepository;
import com.pfma.repository.postgresdb1.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public User createUser(User user) {

        user.setId(UUID.randomUUID());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info("*USER CREATED* " + user.getUsername());
        return userRepository.save(user);
    }

    public Optional<User> getUser(UUID id) {
        logger.info("*USER EXTRACTED* " +userRepository.findUserNameById(id));
        return userRepository.findById(id);
    }


    public void updateUserAndLogout(User user, Principal principal) {
        AppUserDetails userDetails = (AppUserDetails) principal;
        if(!userRepository.findUserIdByUsername(principal.getName()).equals(user.getId())) {
            logger.error("Forbidden operation: user: " + userDetails.getUsername() + " have tried to alter user: "
             + user.getId());
            throw new ForbiddenOperation("FORBIDDEN");
        }
        Optional<User> alteredUserOptional= userRepository.findById(user.getId());
        if(alteredUserOptional.isPresent()){
            transactionTemplate.execute(status -> {
                        User alteredUser = alteredUserOptional.get();
                        alteredUser.setEmail(user.getEmail());
                        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                        alteredUser.setPassword(passwordEncoder.encode(user.getPassword()));
                        alteredUser.setImage(user.getImage());
                        alteredUser.setName(user.getName());
                return null;
                    });
            logger.info("User: "+ userDetails.getUsername() + " have been changed");

            //todo logout user to change Principal object

            logger.info("User: "+ userDetails.getUsername() + " logged out");

        }else {
            throw new UserNotFoundException("User not found");
        }
    }

    public void deleteUser(UUID id,String password, Principal principal) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        AppUserDetails userDetails = (AppUserDetails) principal;
        if(userRepository.findUserIdByUsername(principal.getName()).equals(userDetails.getId()) &&
            userDetails.getPassword().equals(passwordEncoder.encode(password))
        ) {

            userRepository.deleteById(id);
            logger.info("User: " + userRepository.findUserNameById(id) + " have been deleted");
        }
        else {
            logger.error("Forbidden operation: user: " + userDetails.getUsername() + " have tried to delete user: "
                    + userRepository.findUserNameById(id));
            throw new ForbiddenOperation("FORBIDDEN { bad conditionals}");
        }

    }

}