package com.ahm.jx.ttm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.MediaType;

import com.ahm.jx.ttm.model.AhmjxMstOrganization;
import com.ahm.jx.ttm.model.AhmjxMstPartyCategory;
import com.ahm.jx.ttm.model.AhmjxMstPartyCategoryType;
import com.ahm.jx.ttm.model.AhmjxMstPerson;
import com.ahm.jx.ttm.model.AhmjxMstProductCategoryType;

@Configuration
public class RestMvcConfiguration extends RepositoryRestMvcConfiguration {
	
	@Override
	public RepositoryRestConfiguration config() {
	    RepositoryRestConfiguration config = super.config();
	    config.setBasePath("/api");
	    config.setDefaultPageSize(10);
	    config.setDefaultMediaType(MediaType.APPLICATION_JSON);	    
	    config.exposeIdsFor(
	    		AhmjxMstPartyCategoryType.class, 
	    		AhmjxMstPartyCategory.class,
	    		AhmjxMstPerson.class,
	    		AhmjxMstOrganization.class,
	    		AhmjxMstProductCategoryType.class);
	    return config;
	}
}
