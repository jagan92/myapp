package com.myapp.entity.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.myapp.constants.AppConstants;

@MappedSuperclass
public class BaseSoftDeletable extends BaseEntity {

  private static final long serialVersionUID = -1421527807926868953L;

  @Column(name = "is_deleted", nullable = false)
  private Character deleted = AppConstants.NO;

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
    BaseSoftDeletable other = (BaseSoftDeletable) obj;
    return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
  }

  /********************** boolean getters **********************/

  public boolean isDeleted() {
    return deleted == AppConstants.YES;
  }

  /********************** Getters and Setters **********************/

  public Character getDeleted() {
    return deleted;
  }

  public void setDeleted(Character deleted) {
    this.deleted = deleted;
  }

}
