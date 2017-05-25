/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Test client for use with social application (as an OAuth2 auth server). Remember to
 * access this app via its IP address (not "localhost"), otherwise the auth server will
 * steal your cookie.
 * 
 * @author Dave Syer
 *
 */
@EnableAutoConfiguration
@Configuration
@EnableOAuth2Sso
@RestController
public class ClientApplication extends  WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/client").hasRole("USER").anyRequest().authenticated();
		;
	}
	
	@RequestMapping("/client")
	public String home(Principal user) {
		return "Hello " + user.getName();
	}
	
//	@Bean
//	public OAuth2RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext) {
//		return new OAuth2RestTemplate(resource(), oauth2ClientContext);
//	}
//
//	@Bean
//	protected OAuth2ProtectedResourceDetails resource() {
//		AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
//		resource.setAccessTokenUri(tokenUrl);
//		resource.setUserAuthorizationUri(authorizeUrl);
//		resource.setClientId("my-trusted-client");
//		return resource ;
//	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApplication.class).run(args);
	}

}
