package ru.itm.spring.boot_security.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itm.spring.boot_security.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
