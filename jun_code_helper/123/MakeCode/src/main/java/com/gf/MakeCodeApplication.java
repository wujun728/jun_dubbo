package com.gf;

import com.gf.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MakeCodeApplication {

	private final static Logger logger = LoggerFactory.getLogger(MakeCodeApplication.class);

	public static void main(String[] args) {

		ApplicationContext application = SpringApplication.run(MakeCodeApplication.class, args);
		logger.info("SpringbootMybatisApplication is success!");
		Environment env = application.getEnvironment();
		SpringContextHolder.setAppContext(application);

		logger.info("Localhost url: http://{}:{}/swagger-ui.html", env.getProperty("host", "localhost"), env.getProperty("server.port", "8080"));
	}
}
