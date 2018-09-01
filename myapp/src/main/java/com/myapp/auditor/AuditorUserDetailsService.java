package com.myapp.auditor;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.repository.UserRepository;

@Component
@Transactional(readOnly = true)
public class AuditorUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	HttpSession httpSession;

	@Override
	public UserDetails loadUserByUsername(String loginId) {
		com.myapp.entity.User user = userRepository.findByLoginId(loginId);
		if (user == null) {
			throw new UsernameNotFoundException("UserName " + loginId + " not found");
		}
		return new SecurityUser(user);
	}
}