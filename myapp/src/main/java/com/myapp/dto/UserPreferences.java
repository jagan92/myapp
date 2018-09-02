package com.myapp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.myapp.constants.AppConstants;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserPreferences implements Serializable, UserDetails {

	private static final long serialVersionUID = -7860190318850582526L;

	private Long id;
	private String userName;
	private String displayName;
	private String role;
	private String roleType;

	private List<String> permissions;

	/********************** hashcode, and equals methods **********************/

	@Override
	public String toString() {
		return String.format("UserPreferences [id = %d]", id);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		UserPreferences other = (UserPreferences) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	public boolean hasPermission(String capability, String action) {
		return getPermissions().contains(capability + "-" + action);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>(1);
	}

	@Override
	public String getPassword() {
		return "";
	}

	@Override
	public String getUsername() {
		return this.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
