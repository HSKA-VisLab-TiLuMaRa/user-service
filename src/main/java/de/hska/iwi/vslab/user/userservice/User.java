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

	@Column(name = "USER_NAME")
	private String name;

	@Column(name = "USER_PWD")
	private String passwd;

	public User(){}

	public User(Long id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.passwd = pwd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + "]";
	}

}
