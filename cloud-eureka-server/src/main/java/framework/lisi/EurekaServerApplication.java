package framework.lisi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //开启eureka服务
@SpringBootApplication //springBoot注解,spring在springBoot基础之上来构建项目
public class EurekaServerApplication {
	 //spirng boot的标准入口
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
	}
}
