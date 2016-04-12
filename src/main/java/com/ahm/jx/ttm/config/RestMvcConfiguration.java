package com.ahm.jx.ttm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RestMvcConfiguration extends RepositoryRestMvcConfiguration {
	
	@Override
	public RepositoryRestConfiguration config() {
	    RepositoryRestConfiguration config = super.config();
	    config.setBasePath("/api");
	    return config;
	}
}
