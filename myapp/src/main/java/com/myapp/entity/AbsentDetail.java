package com.myapp.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.myapp.entity.base.BaseSoftDeletable;

@Entity
@Table(name = "absent_details")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "absent_detail_id")) })
public class AbsentDetail extends BaseSoftDeletable {

	private static final long serialVersionUID = 1031918986534073141L;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "status")
	private String status;

	@Column(name = "absent_date")
	private Date absentDate;

	@Column(name = "is_absent")
	private boolean absent;

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
		AbsentDetail other = (AbsentDetail) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	/********************** Getters and Setters **********************/

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAbsentDate() {
		return absentDate;
	}

	public void setAbsentDate(Date absentDate) {
		this.absentDate = absentDate;
	}

	public boolean getAbsent() {
		return absent;
	}

	public void setAbsent(boolean absent) {
		this.absent = absent;
	}

}
