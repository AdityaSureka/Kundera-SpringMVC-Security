package com.easytest.easytst.login.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "user", schema = "easytst@cassandra")
public class User {
 
	
	@Id    
	@Column(name="user_id")
    private String user_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@ElementCollection
    @Column(name="userrole")
	private Set<String> userRole;
	
	public User() {
	}
 
	public User(String user_id,String username, String password, boolean enabled) {
        this.user_id=user_id;
		this.username = username;	
		this.password = password;
		this.enabled = enabled;
	}
 
	
	public User(String user_id, String username, String password, 
		boolean enabled, Set<String> userRole) {
        this.user_id=user_id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}
 
    /**
     * @return the user_id
        */
    public String getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
	public String getUsername() {
		return this.username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return this.password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public boolean isEnabled() {
		return this.enabled;
	}
 
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
 
	public Set<String> getUserRole() {
		return this.userRole;
	}
 
	public void setUserRole(Set<String> userRole) {
		this.userRole = userRole;
	}
}