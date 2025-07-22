package com.cbase.userregistration.controller;

import com.cbase.userregistration.business.UserService;
import com.cbase.userregistration.configuration.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> findUserById(@RequestParam Integer id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserById(@RequestParam Integer id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUserById(@RequestParam Integer id, @RequestBody User user){
        userService.updateUserById(id, user);
        return ResponseEntity.ok().build();
    }
}
