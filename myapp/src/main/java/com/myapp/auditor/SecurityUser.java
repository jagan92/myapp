package com.myapp.auditor;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.myapp.constants.AppConstants;
import com.myapp.entity.User;

public class SecurityUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	private final User user;

	private final Collection<? extends GrantedAuthority> grantedAuthorities;

	public SecurityUser(User user) {
		this(user, new ArrayList<GrantedAuthority>(1));
	}

	public SecurityUser(User user, Collection<? extends GrantedAuthority> grantedAuthorities) {
		this.user = user;
		this.grantedAuthorities = grantedAuthorities;
	}

	/**********************
	 * hashcode, equals and toString methods
	 **********************/

	@Override
	public String toString() {
		return String.format("SecurityUser [id = %d]", user.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getUser().getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		SecurityUser other = (SecurityUser) obj;
		return new EqualsBuilder().append(this.getUser().getId(), other.getUser().getId()).isEquals();
	}

	/********************** Getters and Setters **********************/

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getLoginId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public User getUser() {
		return user;
	}
}
