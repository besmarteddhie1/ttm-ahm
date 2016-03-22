package com.ahm.jx.ttm.services;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahm.jx.ttm.dao.UamRoleDao;
import com.ahm.jx.ttm.dao.UamUserDao;
import com.ahm.jx.ttm.entities.UamRole;
import com.ahm.jx.ttm.entities.UamUser;
import com.ahm.jx.ttm.entities.UamUserRole;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountService implements UserDetailsService {
	
	@Autowired
	private UamUserDao userRepository;
	
	@Autowired
	private UamRoleDao roleRepository;	

	private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

	@PostConstruct	
	public void initialize() {
		save(new UamUser("user", "demo"), "ROLE_USER");
		save(new UamUser("admin", "admin"), "ROLE_ADMIN");
	}

	@Transactional
	public UamUser save(UamUser account, String role) {
		UamRole r = roleRepository.findOneByIdRole(role);
		if (r != null) {
			UamUserRole ur = new UamUserRole();
			ur.setRole(r);
			ur.setUser(account);
			account.getUserRoles().add(ur);
		}
		account.setPassword(passwordEncoder.encodePassword(account.getPassword(), null));
		userRepository.save(account);
		return account;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UamUser account = userRepository.findOneByUserName(username);
		if(account == null) {			
			throw new UsernameNotFoundException(username + " in data not found");
		}
		return createUser(account);
	}
	
	public void signin(UamUser account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}
	
	private Authentication authenticate(UamUser account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));		
	}
	
	private User createUser(UamUser account) {
		return new User(account.getUserName(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}

	private GrantedAuthority createAuthority(UamUser account) {
		return new SimpleGrantedAuthority(account.getRoles().toString());
	}

}
