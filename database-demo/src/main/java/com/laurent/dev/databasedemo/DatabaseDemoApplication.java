package com.laurent.dev.databasedemo;

import com.laurent.dev.databasedemo.entity.Person;
import com.laurent.dev.databasedemo.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User nr. 3 -> {}", dao.findById(10003));
		logger.info("User nr. 2 Deleted -> {}", dao.deleteById(10002));

		logger.info("Insert nr. 3 added -> {}", dao.insert(new Person(10002, "Peder", "Oslo", new Date())));
		logger.info("Update person 10002 -> {}", dao.update(new Person(10002, "Frida", "Hauger", new Date())));
	}
}
