package com.myapp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.myapp.entity.base.BaseSoftDeletable;

@Entity
@Table(name = "users")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "user_id")) })
public class User extends BaseSoftDeletable {

	private static final long serialVersionUID = -4284532910381022091L;

	@Column(name = "user_name", length = 80, nullable = false, unique = true)
	private String loginId;

	@Column(name = "email", length = 80)
	private String emailId;
	
	@Column(name = "password", length = 80)
	private String password;

	@Column(name = "first_name", length = 40)
	private String firstName;

	@Column(name = "last_name", length = 40)
	private String lastName;

	@Column(name = "is_active", length = 40)
	private int active;

	@Column(name = "role", length = 40)
	private String role;
	

	/********************** hashcode, and equals methods **********************/

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		User other = (User) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	/********************** Getters and Setters **********************/

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
