package com.myapp.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.myapp.dto.base.BaseVO;

public class AbsentDetailVO extends BaseVO {

	private static final long serialVersionUID = 3812586049729078253L;

	private Long userId;
	private String status;
	private Date absentDate;
	private UserVO userVO;

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
		AbsentDetailVO other = (AbsentDetailVO) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	/********************** Getters and Setters **********************/

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getAbsentDate() {
		return absentDate;
	}

	public void setAbsentDate(Date absentDate) {
		this.absentDate = absentDate;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
