package framework.lisi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/** 
* @author lisi
* @since 2017年4月18日 
*/
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class TestApplication  extends  WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
