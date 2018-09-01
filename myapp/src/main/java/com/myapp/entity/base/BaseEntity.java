package com.myapp.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.myapp.entity.User;
import com.myapp.utils.EncryptionUtils;

@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public class BaseEntity implements Auditable<User, Long> {

	private static final long serialVersionUID = 8061880944976007326L;

	@Id
	@GeneratedValue
	private Long id;

	@Transient
	private String encryptedId;

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
		BaseEntity other = (BaseEntity) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	/********************** toString methods **********************/

	@Override
	public String toString() {
		return String.format("%s [id = %d]", this.getClass().getName(), this.getId());
	}

	/********************** Transient **********************/

	@Transient
	public boolean isNew() {
		return null == getId();
	}

	/********************** Getters and Setters **********************/

	public Long getId() {
		return id;
	}

	protected void setId(final Long id) {
		this.id = id;
	}

	public String getEncryptedId() {
		if (encryptedId == null) {
			setEncryptedId(EncryptionUtils.encryptId(id));
		}
		return encryptedId;
	}

	protected void setEncryptedId(final String encryptedId) {
		this.encryptedId = encryptedId;
	}

	public User getCreatedBy() {
		// TODO Auto-generated method stub
		return null;
	}

	public DateTime getCreatedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getLastModifiedBy() {
		// TODO Auto-generated method stub
		return null;
	}

	public DateTime getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCreatedBy(User arg0) {
		// TODO Auto-generated method stub

	}

	public void setCreatedDate(DateTime arg0) {
		// TODO Auto-generated method stub

	}

	public void setLastModifiedBy(User arg0) {
		// TODO Auto-generated method stub

	}

	public void setLastModifiedDate(DateTime arg0) {
		// TODO Auto-generated method stub

	}

}
