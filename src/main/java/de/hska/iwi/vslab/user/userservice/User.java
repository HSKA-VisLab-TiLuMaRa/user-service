package de.hska.iwi.vslab.user.userservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "USER_USERNAME")
	private String username;

	@Column(name = "USER_PWD")
	private String passwd;

	@Column(name = "USER_FIRSTNAME")
	private String firstname;

	@Column(name = "USER_LASTNAME")
	private String lastname;

	@Column(name = "USER_ROLEID")
	private Integer roleId;

	public User(){}

	public User(Long id, String username, String pwd, String firstname, String lastname, Integer roleId) {
		this.id = id;
		this.username = username;
		this.passwd = pwd;
		this.firstname = firstname;
		this.lastname = lastname;
		this.roleId = roleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwd=" + passwd + "]";
	}

}
