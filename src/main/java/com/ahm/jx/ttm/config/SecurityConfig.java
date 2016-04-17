package com.ahm.jx.ttm.config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import com.ahm.jx.ttm.service.AccountService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
class SecurityConfig {

    @Autowired
    private AccountService accountService;
    
	@Autowired
	DataSource dataSource;
		
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
	  	.passwordEncoder(new Md5PasswordEncoder())
		.usersByUsernameQuery(
			"select vusername username, vpassword password, vstat enabled from ahmjxuam_mstusers where vusername=?")
		.authoritiesByUsernameQuery(
			"  select a.vusername username, d.vmenu_id role "
			+ "  from ahmjxuam_mstusers a "
			+ " inner join ahmjxuam_mstusrrols b on (b.vid_ahmjxuam_mstusers = a.vid) "
			+ " inner join ahmjxuam_hdrrlaccess c on (c.vid_ahmjxuam_mstroles = b.vid_ahmjxuam_mstroles) "
			+ " inner join ahmjxuam_mstmenus d on (c.vid_ahmjxuam_mstmenus = d.vid) where a.vusername=? "
			+ " group by a.vusername, d.vmenu_id");
	}	    

    @Bean
    public TokenBasedRememberMeServices rememberMeServices() {
        return new TokenBasedRememberMeServices("remember-me-key", accountService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
	}

    @Bean
    public AccessDecisionManager defaultAccessDecisionManager() {
        List<AccessDecisionVoter<?>> voters = new ArrayList<AccessDecisionVoter<?>>();
        voters.add(new RoleVoter());
        voters.add(new AuthenticatedVoter());
        AccessDecisionManager result = new AffirmativeBased(voters);
        return result;
    }
    
    @Configuration
    @Order(2)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/**")
                .authorizeRequests()
                	.anyRequest().authenticated()
                	.and()                	
                .httpBasic()
                	.and()
                .csrf()
             		.disable();                	
        }
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    	
    	@Inject
    	TokenBasedRememberMeServices rememberMe;
    	
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http        	
            .authorizeRequests()
                .antMatchers("/", "/favicon.ico", "/resources/**", "/error", "/forgot*").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/login?error=1")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("username").passwordParameter("password")
                .and()                
            .logout()
                .logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/login?logout")
                .and()
            .rememberMe()
                .rememberMeServices(rememberMe)
                .key("remember-me-key")
                .and()
             .csrf()
             	.disable();
        }
    }    
    
}