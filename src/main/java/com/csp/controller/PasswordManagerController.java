package com.csp.controller;
import com.csp.bean.PasswordManager;
import com.csp.service.PasswordManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class PasswordManagerController {

    @Autowired
    private PasswordManagerService passwordManagerService;

    @PostMapping("/insertPasswordManagers")
    public void performInsert(@RequestBody PasswordManager passwordManager) {
        passwordManagerService.saveOrUpdatePasswordManager(passwordManager);
    }

    @PutMapping("/updatePasswordManagers")
    public void performUpdate(@RequestBody PasswordManager passwordManager) {
        passwordManagerService.saveOrUpdatePasswordManager(passwordManager);
    }

    @DeleteMapping("/deletePasswordManagers/{passwordId}")
    public void performDelete(@PathVariable Long passwordId) {
        passwordManagerService.deletePasswordManagerById(passwordId);
    }

    @GetMapping("/findAllPasswordManagers")
    public List<PasswordManager> viewAllPasswordManagers() {
        return passwordManagerService.getAllPasswordManagers();
    }
}