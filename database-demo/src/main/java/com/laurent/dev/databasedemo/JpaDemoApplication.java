package com.laurent.dev.databasedemo;


import com.laurent.dev.databasedemo.entity.Person;
import com.laurent.dev.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User nr. 3 -> {}", repository.findById(10003));

		logger.info("Inserting 10004 -> {}",
				repository.insert(new Person("Allan Holdsworth", "England", new Date())));

		logger.info("Inserting 10004 -> {}",
				repository.update(new Person(1, "Elvis", "USA", new Date())));

		//repository.delete(1);

		logger.info("All persons: -> {}\n",
				repository.findAll());
	}
}
