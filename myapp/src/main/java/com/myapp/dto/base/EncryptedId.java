package com.myapp.dto.base;

import java.io.Serializable;

import com.myapp.utils.EncryptionUtils;

public class EncryptedId implements Serializable {

  private static final long serialVersionUID = -4765075282535874591L;

  private Long id = null;

  public EncryptedId(String encryptedId) {
    this.id = EncryptionUtils.decryptId(encryptedId);
  }

  public EncryptedId(Long id) {
    this.id = id;
  }

  public String getEncryptedId() {
    // Need to trigger URL encode. Hence call encryption utils.
    return EncryptionUtils.encryptId(id);
  }

  /********************** Getters and Setters **********************/

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  /********************** toString methods **********************/

  @Override
  public String toString() {
    return String.format("%s [id = %d]", this.getClass().getName(), this.getId());
  }

}
