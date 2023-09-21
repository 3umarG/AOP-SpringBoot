package com.aop.demo;

import com.aop.demo.entities.Comment;
import com.aop.demo.services.CommentsService;
import com.aop.demo.services.impl.CommentsServiceImpl;
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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOGGER.info("Starting the application");

		var comment = new Comment("Comment 1 content","Author 1");

		var result = service.publishComment(comment);
		LOGGER.info("The actual result of method : "+result);

		service.deleteComment(comment);
	}
}
