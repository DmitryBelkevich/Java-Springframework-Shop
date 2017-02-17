package com.hard.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User extends Model implements UserDetails {
	private static final long serialVersionUID = 6755436916675115797L;
	
	@NotNull
	@Size(min = 5, max = 25)
	@Column(name = "username", length = 25)
	private String username;
	
	@NotNull
	@Column(name = "password", length = 64)
	private String password;
	
	//@Column(name = "enabled")
	//private boolean enabled;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name = "user_role",
		joinColumns = {
			@JoinColumn(
				name = "user_id",
				referencedColumnName = "id",
				nullable = false,
				updatable = false
			)
		},
		inverseJoinColumns = {
			@JoinColumn(
				name = "role_id",
				referencedColumnName = "id",
				nullable = false,
				updatable = false
			)
		}
	)
	private Set<Role> roles = new HashSet<>();
	
	public User() {
		super();
	}
	
	public User(long id) {
		super(id);
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		for (Role role : roles)
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getTitle()));
		
		return grantedAuthorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String toString() {
		return "User["
				+ "id=" + id
				+ ", username=" + username
				+ ", password=" + password
				//+ ", roles=[" + roles + "]"
				+ "]";
	}
}