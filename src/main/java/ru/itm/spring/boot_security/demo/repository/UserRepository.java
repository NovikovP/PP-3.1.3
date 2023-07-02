package ru.itm.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itm.spring.boot_security.demo.entity.User;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}