package com.projgobackend.projgo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projgobackend.projgo.dto.UserDto;
import com.projgobackend.projgo.entity.User;
import com.projgobackend.projgo.entity.Response.AffectResponse;
import com.projgobackend.projgo.service.UserImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin
public class UserController {
    private UserImpl userService;

    public UserController(UserImpl userService) {
        this.userService = userService;
    }

    @PostMapping("adduser")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> fetchAllUsers() {
        return ResponseEntity.ok().body(userService.fetchAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getOneUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.fetchOneUser(id));
    }

    @PostMapping("affectTaskToUser/{iduser}/{idtask}")
    public ResponseEntity<AffectResponse> affectTaskToUser(@PathVariable Long iduser, @PathVariable Long idtask) {
        return ResponseEntity.ok().body(userService.affecTaskToUser(iduser, idtask));
    }

}