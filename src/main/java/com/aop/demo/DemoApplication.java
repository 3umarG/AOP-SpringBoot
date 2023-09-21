package com.aop.demo;

import com.aop.demo.entities.Comment;
import com.aop.demo.services.CommentsService;
import com.aop.demo.services.SecretDataService;
import com.aop.demo.services.impl.CommentsServiceImpl;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication implements CommandLineRunner {
	private final static Logger LOGGER =
			LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private CommentsService service;

	@Autowired
	private SecretDataService secretDataService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String secretsResult = secretDataService.getSecrets();
		LOGGER.info("Get the final result : "+secretsResult);
	}

	private void testSimpleAspects() {
		LOGGER.info("Starting the application");

		var comment = new Comment("Comment 1 content","Author 1");

		var result = service.publishComment(comment);
		LOGGER.info("The actual result of method : "+result);

		LOGGER.info("********************************");

		service.deleteComment(comment);

		LOGGER.info("********************************");

		service.updateComment(comment);
	}
}
