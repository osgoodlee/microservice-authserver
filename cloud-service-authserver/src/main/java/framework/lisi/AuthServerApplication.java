package framework.lisi;

import java.security.Principal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class AuthServerApplication {

	@Autowired
	private DataSource dataSource;

	@Bean
	public JdbcTokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
//		System.out.println("登录用户：" + user.getName());
		return user;
	}
	
	@Configuration
	@Order(-20)
	protected static class LoginConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private DataSource dataSource;
		
		@Autowired
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.formLogin().loginPage("/login").permitAll().and()
					.requestMatchers().antMatchers("/login","/oauth/authorize", "/oauth/confirm_access").and()
//					.requestMatchers().antMatchers("/**").and()
//					.authorizeRequests().antMatchers("/login", "/index", "/oauth/authorize", "/oauth/confirm_access").permitAll().and()
					.authorizeRequests().anyRequest().authenticated()
//					.and().sessionManagement()
//                    .maximumSessions(2).maxSessionsPreventsLogin(true)
//                    .expiredUrl("/index")
					;
			// @formatter:on
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.parentAuthenticationManager(authenticationManager);
			auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
		}
	}

	@Configuration
	@EnableResourceServer
	protected static class ResourceServer extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
//			http.authorizeRequests().antMatchers("/*.jpg").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
			http.authorizeRequests().anyRequest().authenticated();
		}
	}
	

	@Configuration
	@EnableAuthorizationServer
	protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private AuthenticationManager auth;

		@Autowired
		private DataSource dataSource;

		@Autowired
		private BCryptPasswordEncoder passwordEncoder;

		@Autowired
		private TokenStore tokenStore;

		@Bean
		protected AuthorizationCodeServices authorizationCodeServices() {
			return new JdbcAuthorizationCodeServices(dataSource);
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			security.passwordEncoder(passwordEncoder);
			security.allowFormAuthenticationForClients();
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.authorizationCodeServices(authorizationCodeServices()).authenticationManager(auth)
					.tokenStore(tokenStore).approvalStoreDisabled();
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// @formatter:off
			clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
			// @formatter:on
		}

	}
}
