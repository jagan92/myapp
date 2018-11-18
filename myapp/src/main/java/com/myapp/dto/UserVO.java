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
	private StudentDetailVO studentDetailVO;
	private StaffDetailVO staffDetailVO;

	public UserVO() {
		this.studentDetailVO = new StudentDetailVO();
	}

	public UserVO(User user) {
		BeanUtils.copyProperties(user, this);
		this.setId(user.getId());
	}

	public UserVO(User user, boolean isReq) {
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setRole(user.getRole());
		this.setId(user.getId());
	}

	public UserVO(User user, boolean isReq, StudentDetailVO studentDetailVO) {
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setRole(user.getRole());
		this.setId(user.getId());
		this.studentDetailVO = studentDetailVO;
	}
	
	public UserVO(User user, boolean isReq, StaffDetailVO staffDetailVO) {
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setRole(user.getRole());
		this.setId(user.getId());
		this.staffDetailVO = staffDetailVO;
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

	public StudentDetailVO getStudentDetailVO() {
		return studentDetailVO;
	}

	public void setStudentDetailVO(StudentDetailVO studentDetailVO) {
		this.studentDetailVO = studentDetailVO;
	}

	public StaffDetailVO getStaffDetailVO() {
		return staffDetailVO;
	}

	public void setStaffDetailVO(StaffDetailVO staffDetailVO) {
		this.staffDetailVO = staffDetailVO;
	}

}
