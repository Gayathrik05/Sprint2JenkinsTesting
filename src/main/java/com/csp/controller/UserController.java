package com.csp.controller;
 
import com.csp.dto.UserDTO;
import com.csp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@CrossOrigin("http://localhost:4200/")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @PostMapping("/insertUsers")
    public void performInsert(@RequestBody UserDTO user) {
        userService.saveOrUpdateUser(user);
    }
 
    @PutMapping("/updateUsers")
    public void performUpdate(@RequestBody UserDTO user) {
        userService.saveOrUpdateUser(user);
    }
 
    @DeleteMapping("/deleteUsers/{userId}")
    public void performDelete(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }
 
 
    @GetMapping("/findAllEmployees")
    public List<UserDTO> viewAllEmployees() {
        return userService.getAllEmployees();
    }
    @GetMapping("/MapAllEmployees")
    public List<UserDTO> mapEmployees() {
        return userService.getEmployeesToMap();
    }

}