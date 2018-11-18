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
@Table(name = "staff_details")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "staff_detail_id")) })
public class StaffDetail extends BaseSoftDeletable {

	private static final long serialVersionUID = -4676836238444261665L;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "staff_role")
	private String staffRole;

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		StaffDetail other = (StaffDetail) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

}
