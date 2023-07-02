package ru.itm.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itm.spring.boot_security.demo.entity.User;
import ru.itm.spring.boot_security.demo.exeptions.UserErrorResponse;
import ru.itm.spring.boot_security.demo.exeptions.UserNotCreatedException;
import ru.itm.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminRestController {
    private final UserService service;

    @Autowired
    public AdminRestController(UserService service) {
        this.service = service;
    }

    @GetMapping("/table")
    public List<User> findAll() {
        return service.findAllUsers();
    }

    @GetMapping("/found/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return service.findUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteUser(@PathVariable("id") Long id) {
        service.deleteUserById(id);
        return id;
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid User user, BindingResult bindingResult) {
        return service.checkErrorAddUser(user, bindingResult);
    }

    @PostMapping("/saveuser")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid User user, BindingResult bindingResult) {
        return service.checkErrorUpdateUser(user, bindingResult);
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UsernameNotFoundException e) {
        UserErrorResponse userErrorResponse = new UserErrorResponse("User with this id not found!", System.currentTimeMillis());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserNotCreatedException e) {
        UserErrorResponse userErrorResponse = new UserErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(userErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
