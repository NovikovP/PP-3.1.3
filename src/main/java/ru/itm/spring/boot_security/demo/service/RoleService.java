package ru.itm.spring.boot_security.demo.service;

import ru.itm.spring.boot_security.demo.entity.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();

    Set<Role> getRoleByName(String[] roleName);
}
