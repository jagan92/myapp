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
@Table(name = "master_details")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "master_detail_id")) })
public class MasterDetails extends BaseSoftDeletable {

	private static final long serialVersionUID = 3280073690025679987L;

	@Column(name = "name", length = 200)
	private String name;

	@Column(name = "master_type", length = 80)
	private String masterType;

	@Column(name = "parent_id", length = 80)
	private Long parentId;

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
		MasterDetails other = (MasterDetails) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	/********************** Getters and Setters **********************/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
