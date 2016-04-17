package com.ahm.jx.ttm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountService accountService;
    
	@Autowired
	DataSource dataSource;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
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

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .eraseCredentials(true)
            .userDetailsService(accountService)
            .passwordEncoder(passwordEncoder());
    }
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http        	
            .authorizeRequests()
            	//.antMatchers(HttpMethod.POST, "/api/**").permitAll()
            	//.antMatchers(HttpMethod.PUT, "/api/**").permitAll()
            	//.antMatchers(HttpMethod.DELETE, "/api/**").permitAll()
            	//.antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .antMatchers("/", "/favicon.ico", "/resources/**", "/error").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/login?error=1")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("username").passwordParameter("password")
                .and()
//            .httpBasic()
//            	.and()                
            .logout()
                .logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/login?logout")
                .and()
            .rememberMe()
                .rememberMeServices(rememberMeServices())
                .key("remember-me-key")
                .and()
             .csrf()
             	.disable();
    }

    @Bean(name = "authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
}