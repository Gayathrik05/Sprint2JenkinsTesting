package com.csp.service;
 
import com.csp.bean.Login;
import com.csp.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
 
@Service
public class LoginService {
 
    @Autowired
    private LoginDao loginDao;
 
    public boolean saveOrUpdateLogin(Login login) {
        loginDao.save(login);
        return true;
    }
 
    public boolean deleteLoginByEmailId(String emailId) {
        loginDao.deleteById(emailId);
        return true;
    }
 
    public List<Login> getAllLogins() {
        return loginDao.findAll();
    }
    
    
    public String verifyLogin(String userEmailId) {
    	Login login = loginDao.findByUserEmailId(userEmailId);
    	if(login ==null) {
    		return "Failed";
    	}
    	else {
    		return "Success";
    	}
    }
 
    public String verifyLogin(String userEmailId, String password) {
        Login login = loginDao.findByUserEmailIdAndPassword(userEmailId, password);
        
 
        if (login != null) {
            return login.getUserEmailId(); 
        } else {
            return null;
        }
    }
 
    public String getUserTypeByEmail(String email) {
        return loginDao.findByUserEmailId(email).getUserType();
    }
 
    public void updateFailedLoginAttempts(String userEmailId) {
        Login login = loginDao.findByUserEmailId(userEmailId);
        login.setLoginAttempts(login.getLoginAttempts() + 1);
        login.setLastFailedAttempt(LocalDateTime.now());
        loginDao.save(login);
    }
 
    public int getLoginAttempts(String userEmailId) {
    	Login login = loginDao.findByUserEmailId(userEmailId);
    	return login.getLoginAttempts();
    	
    }
    public boolean isLoginDisabled(String userEmailId) {
        Login login = loginDao.findByUserEmailId(userEmailId);
        if (login.getLoginAttempts() >= 5) {
            LocalDateTime lastAttempt = login.getLastFailedAttempt();
            LocalDateTime now = LocalDateTime.now();
            return lastAttempt != null && lastAttempt.isAfter(now.minusMinutes(5));
        }
        return false;
    }
 
    public void resetLoginAttempts(String userEmailId) {
        Login login = loginDao.findByUserEmailId(userEmailId);
        login.setLoginAttempts(0);
        loginDao.save(login);
    }
   
    public Login verifyEmail( String userEmailId)
    {
    	Login login = loginDao.findByUserEmailId(userEmailId);
    	return login;
    	
    	
    }
 
}