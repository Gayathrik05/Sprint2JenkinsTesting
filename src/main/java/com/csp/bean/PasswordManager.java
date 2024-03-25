package com.csp.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_password_manager")
public class PasswordManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "password_id")
    private Long passwordId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "expiration_date")
    private Timestamp expirationDate;

    @Column(name = "last_password_1")
    private String lastPassword1;

    @Column(name = "last_password_2")
    private String lastPassword2;

    @Column(name = "last_password_3")
    private String lastPassword3;

	public PasswordManager() {
		super();
	}

	public PasswordManager(Long passwordId, User user, Timestamp creationDate, Timestamp expirationDate,
			String lastPassword1, String lastPassword2, String lastPassword3) {
		super();
		this.passwordId = passwordId;
		this.user = user;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.lastPassword1 = lastPassword1;
		this.lastPassword2 = lastPassword2;
		this.lastPassword3 = lastPassword3;
	}

	public Long getPasswordId() {
		return passwordId;
	}

	public void setPasswordId(Long passwordId) {
		this.passwordId = passwordId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getLastPassword1() {
		return lastPassword1;
	}

	public void setLastPassword1(String lastPassword1) {
		this.lastPassword1 = lastPassword1;
	}

	public String getLastPassword2() {
		return lastPassword2;
	}

	public void setLastPassword2(String lastPassword2) {
		this.lastPassword2 = lastPassword2;
	}

	public String getLastPassword3() {
		return lastPassword3;
	}

	public void setLastPassword3(String lastPassword3) {
		this.lastPassword3 = lastPassword3;
	}
   
}