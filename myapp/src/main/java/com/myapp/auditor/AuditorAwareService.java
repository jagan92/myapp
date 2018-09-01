package com.myapp.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.myapp.entity.User;

@Component
public class AuditorAwareService implements AuditorAware<User> {

  private User guestUser = null;

  @Override
  public User getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && !authentication.isAuthenticated()) {
      return null;
    }
    if (authentication == null) {
      return guestUser;
    }
    return ((SecurityUser) authentication.getPrincipal()).getUser();
  }

  public void setGuestUser(User guestUser) {
    this.guestUser = guestUser;
  }

}