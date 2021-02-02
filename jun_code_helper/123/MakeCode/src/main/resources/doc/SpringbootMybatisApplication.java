import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
@SpringBootApplication
public class ${productName}Application {
	private final static Logger logger = LoggerFactory.getLogger(${productName}Application.class);
	public static void main(String[] args) {
		ApplicationContext application = SpringApplication.run(${productName}Application.class, args);
		logger.info("${productName}Application is success!");
		Environment env = application.getEnvironment();
		logger.info("Localhost url: http://{}:{}/swagger-ui.html", env.getProperty("host", "localhost"), env.getProperty("server.port", "8080"));
	}
}
