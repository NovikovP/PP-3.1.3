package ru.itm.spring.boot_security.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import ru.itm.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    List<User> findAllUsers();
    void deleteUserById(Long id);
    UserDetails loadUserByUsername(String username);
    boolean saveUser(User user);
    boolean updateUser(User user);
    Long getUsernameByName(String name);
    User getUserAndRoles(User user, String[] roles);
    User getNotNullRole(User user);
    void addTestUsers();

    ResponseEntity<HttpStatus> checkErrorAddUser(User user, BindingResult bindingResult);
    ResponseEntity<HttpStatus> checkErrorUpdateUser(User user, BindingResult bindingResult);
}
