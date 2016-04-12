package com.ahm.jx.ttm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.MediaType;

import com.ahm.jx.ttm.model.AhmjxmstOrganization;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategory;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategoryType;
import com.ahm.jx.ttm.model.AhmjxmstPerson;
import com.ahm.jx.ttm.model.AhmjxmstProductCategoryType;

@Configuration
public class RestMvcConfiguration extends RepositoryRestMvcConfiguration {
	
	@Override
	public RepositoryRestConfiguration config() {
	    RepositoryRestConfiguration config = super.config();
	    config.setBasePath("/api");
	    config.setDefaultPageSize(5);
	    config.setDefaultMediaType(MediaType.APPLICATION_JSON);	    
	    config.exposeIdsFor(
	    		AhmjxmstPartyCategoryType.class, 
	    		AhmjxmstPartyCategory.class,
	    		AhmjxmstPerson.class,
	    		AhmjxmstOrganization.class,
	    		AhmjxmstProductCategoryType.class);
	    return config;
	}
}
