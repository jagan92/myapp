package com.myapp.dto.base;

import java.io.Serializable;

import com.myapp.utils.EncryptionUtils;

public class BaseVO implements Serializable {

	private static final long serialVersionUID = -9033660322742666308L;

	private Long id = null;
	private String encryptedId;

	// Variable to transfer the error message during the operation.
	private String statusMsg = null;

	/********************** Getters and Setters **********************/

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getEncryptedId() {
		if (encryptedId == null) {
			setEncryptedId(EncryptionUtils.encryptId(id));
		}
		return encryptedId;
	}

	public void setEncryptedId(final String encryptedId) {
		this.encryptedId = encryptedId;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public boolean isNew() {
		return id == null ? true : false;
	}

	/********************** toString methods **********************/

	@Override
	public String toString() {
		return String.format("%s [id = %d]", this.getClass().getName(), this.getId());
	}

}
