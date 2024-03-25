package com.csp.dao;

import com.csp.bean.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends JpaRepository<Login, String> {
	Login findByUserEmailIdAndPassword(String userEmailId, String password);
    Login findByUserEmailId(String userEmailId);
}