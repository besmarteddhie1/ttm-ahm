package com.ahm.jx.ttm.utils;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;

public class BsVoter implements AccessDecisionVoter<Object> {
	
	// ~ Static fields/initializers
	// =====================================================================================

	public static final String IS_AUTHENTICATED_FULLY = "IS_AUTHENTICATED_FULLY";
	public static final String IS_AUTHENTICATED_REMEMBERED = "IS_AUTHENTICATED_REMEMBERED";
	public static final String IS_AUTHENTICATED_ANONYMOUSLY = "IS_AUTHENTICATED_ANONYMOUSLY";
	// ~ Instance fields
	// ================================================================================================

	private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();

	// ~ Methods
	// ========================================================================================================

	private boolean isFullyAuthenticated(Authentication authentication) {
		return (!authenticationTrustResolver.isAnonymous(authentication) && !authenticationTrustResolver
				.isRememberMe(authentication));
	}

	public void setAuthenticationTrustResolver(
			AuthenticationTrustResolver authenticationTrustResolver) {
		Assert.notNull(authenticationTrustResolver,
				"AuthenticationTrustResolver cannot be set to null");
		this.authenticationTrustResolver = authenticationTrustResolver;
	}

	public boolean supports(ConfigAttribute attribute) {
		if ((attribute.getAttribute() != null)
				&& (IS_AUTHENTICATED_FULLY.equals(attribute.getAttribute())
						|| IS_AUTHENTICATED_REMEMBERED.equals(attribute.getAttribute()) || IS_AUTHENTICATED_ANONYMOUSLY
							.equals(attribute.getAttribute()))) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public int vote(Authentication authentication, Object object,
			Collection<ConfigAttribute> attributes) {
		int result = ACCESS_ABSTAIN;
		System.out.println("Check Object : " + object.toString() + " : " + object);
		return result;
	}
}

