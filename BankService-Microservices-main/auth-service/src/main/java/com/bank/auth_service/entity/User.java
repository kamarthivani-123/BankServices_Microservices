package com.bank.auth_service.entity;

import org.jspecify.annotations.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true)
	    private String username;
	    private String password;
	    private String role; // ROLE_USER, ROLE_ADMIN

//public String getPassword() {
//    return password;
//}
//
//public String getUsername() {
//    return username;
//}
//
//public String getRole() {
//    return role;
//}

	    public String getPassword() {
	           return password;
	       }

	       public void setPassword(String password) {
	           this.password = password;
	       }

	       public String getUsername() {
	           return username;
	       }

	       public void setUsername(String username) {
	           this.username = username;
	       }

	       public String getRole() {
	           return role;
	       }

	       public void setRole(String role) {
	           this.role = role;
	       }


	}



