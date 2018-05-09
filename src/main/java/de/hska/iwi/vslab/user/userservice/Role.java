package de.hska.iwi.vslab.user.userservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "ROLE_ID")
	private Long id;

	@Column(name = "ROLE_TYPE")
	private String type;

	@Column(name = "ROLE_LEVEL")
	private Long level;

	public Role(){}

	public Role(Long id, String type, Long level) {
		this.id = id;
		this.type = type;
		this.level = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", type=" + type + ", level=" + level + "]";
	}

}
