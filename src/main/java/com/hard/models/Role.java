package com.hard.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role extends Model {
	private static final long serialVersionUID = 2621185875595064422L;
	
	@NotNull
	@Min(value = 4)
	//@Enumerated(EnumType.STRING)
	@Column(name = "title", length = 25)//, insertable = false, updatable = false
	//private RoleList title;
	private String title;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@ManyToMany(
		mappedBy = "roles",
		fetch = FetchType.LAZY
	)
	private Set<User> users = new HashSet<>();
	
	public Role() {
		super();
	}
	
	public Role(long id) {
		super(id);
	}
	
	/*public void setTitle(RoleList title) {
		this.title = title;
	}
	
	public RoleList getTitle() {
		return title;
	}*/
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	@Override
	public String toString() {
		return "Role["
				+ "id=" + id
				+ ", title=" + title
				+ ", description=" + description
				+ ", users=" + users
				+ "]";
	}
}