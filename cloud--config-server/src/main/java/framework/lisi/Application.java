package framework.lisi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

/** 
* @author lisi
* @since 2017年4月18日 
*/
@Configuration
@EnableAutoConfiguration
@EnableConfigServer
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
