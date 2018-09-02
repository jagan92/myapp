package com.myapp.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.BeanUtils;

import com.myapp.dto.base.BaseVO;
import com.myapp.entity.User;

public class UserVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private String role = "admin";
	private String emailId = "test";

	public UserVO() {

	}

	public UserVO(User user) {
		BeanUtils.copyProperties(user, this);
		this.setId(user.getId());
	}

	/********************** HashCode, and equals methods **********************/

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		UserVO other = (UserVO) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	/********************** Getters and Setters **********************/
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
