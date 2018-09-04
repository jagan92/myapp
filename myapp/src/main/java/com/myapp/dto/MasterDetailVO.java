package com.myapp.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.BeanUtils;

import com.myapp.dto.base.BaseVO;
import com.myapp.entity.MasterDetails;

public class MasterDetailVO extends BaseVO {

	private static final long serialVersionUID = 995815845024565742L;

	private String name;
	private String masterType;
	private Long parentId;
	
	public MasterDetailVO() {

	}
	
	public MasterDetailVO(String psMasterType) {
		this.masterType = psMasterType;
	}

	public MasterDetailVO(MasterDetails masterDetails) {
		//BeanUtils.copyProperties(masterDetails, this);
		this.setName(masterDetails.getName());
		this.setMasterType(masterDetails.getMasterType());
		this.setId(masterDetails.getId());
		//this.setEncryptedId(masterDetails.getEncryptedId());
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
		MasterDetailVO other = (MasterDetailVO) obj;
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
