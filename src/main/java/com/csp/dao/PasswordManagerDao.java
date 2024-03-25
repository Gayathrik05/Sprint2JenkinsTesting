package com.csp.dao;
import com.csp.bean.PasswordManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordManagerDao extends JpaRepository<PasswordManager, Long> {
}