package org.jt.farm.yard.controller.application;

import org.jt.farm.yard.dao.DbDao;
import org.jt.farm.yard.dao.impl.DbDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;


@ComponentScan("org.jt*")
@EnableAutoConfiguration


public class Application extends AbstractMongoConfiguration{
	public static void main(String args[]) {
		SpringApplication.run(Application.class,args);
	}
	
	@Override
	public String getDatabaseName() {
		System.out.println("Initialized databasename*********************************");
		
		return "mdb";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		System.out.println("Initialized*********************************");
		return new MongoClient("127.0.0.1");
	}

	
	@Bean
	public DbDao  dbDao() throws Exception {
		System.out.println("Initialized*********************************");
		DbDaoImpl instance = new DbDaoImpl();
		instance.setMongoTemplate(this.mongoTemplate());
		
		return instance;
		
	}
}
