package com.hoo.codegenerator.server;

import com.hoo.codegenerator.server.core.service.TplService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeGeneratorServerApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired TplService tplService;

	@Test
	void contextLoads() {
		logger.info("list:{}", tplService.queryAll());
	}

}
