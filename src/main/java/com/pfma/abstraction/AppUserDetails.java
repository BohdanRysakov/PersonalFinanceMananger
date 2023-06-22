package com.pfma.abstraction;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface AppUserDetails extends UserDetails {
    UUID getId();
    String getPassword();


}