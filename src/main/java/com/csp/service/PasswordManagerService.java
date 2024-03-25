package com.csp.service;
import com.csp.bean.PasswordManager;
import com.csp.dao.PasswordManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordManagerService {

    @Autowired
    private PasswordManagerDao passwordManagerDao;

    public boolean saveOrUpdatePasswordManager(PasswordManager passwordManager) {
        passwordManagerDao.save(passwordManager);
        return true;
    }

    public boolean deletePasswordManagerById(Long passwordId) {
        passwordManagerDao.deleteById(passwordId);
        return true;
    }

    public List<PasswordManager> getAllPasswordManagers() {
        return passwordManagerDao.findAll();
    }
}