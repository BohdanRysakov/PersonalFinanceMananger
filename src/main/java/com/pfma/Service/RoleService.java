package com.pfma.Service;


import com.pfma.model.Role;
import com.pfma.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRole(UUID id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(UUID id, Role role) {
        Role existingRole = getRole(id);
        if (existingRole != null) {
            BeanUtils.copyProperties(role, existingRole, "id");
            return roleRepository.save(existingRole);
        }
        return null;
    }

    public void deleteRole(UUID id) {
        roleRepository.deleteById(id);
    }
}
