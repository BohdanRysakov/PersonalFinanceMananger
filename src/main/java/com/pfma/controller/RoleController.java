package com.pfma.controller;

import com.pfma.Service.RoleService;
import com.pfma.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable UUID id) {
        return roleService.getRole(id);
    }

    @PostMapping
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable UUID id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable UUID id) {
        roleService.deleteRole(id);
    }
}