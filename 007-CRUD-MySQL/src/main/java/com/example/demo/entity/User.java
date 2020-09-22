package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private int active;
	private String roles = "";
	private String permissions = "";
	
	
	public List<String> getRolesList(){
		if (this.roles.length()>0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}
	
	public List<String> getPermissionsList(){
		if (this.permissions.length()>0) {
			return Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<>();
	}

}
