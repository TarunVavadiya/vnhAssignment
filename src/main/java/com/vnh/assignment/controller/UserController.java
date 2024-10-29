package com.vnh.assignment.controller;

import com.vnh.assignment.dto.UserDTO;
import com.vnh.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userBody) throws Exception {
        String response = userService.createUser(userBody);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        List<UserDTO> userDTOList = userService.getAllUsers();
        return ResponseEntity.ok(userDTOList);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userBody, @PathVariable int id) throws Exception {
        String response = userService.updateUser(userBody, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) throws Exception {
        String response = userService.deleteUser(id);
        return ResponseEntity.ok(response);
    }

}
