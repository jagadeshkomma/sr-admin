package com.statusraja.admin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.statusraja.admin.mongo.MongoDBUtil;

@Configuration
public class MongoCongifuration {

	@Autowired
	MongoPropertyLoad mongoPropertyLoad;
	
	private static final Logger logger = LoggerFactory.getLogger(MongoCongifuration.class);
	
	
	@DependsOn(value="mongoPropertyLoad")
	@Bean( name = "mongoDBUtil", initMethod = "getInstance" ) 
	public MongoDBUtil  getMongoDataSource(){
		logger.info("Mongo Database intilaizing....");
		MongoDBUtil	mongodb = new MongoDBUtil();
		mongodb.setUser( mongoPropertyLoad.getUser());
		mongodb.setPassword( mongoPropertyLoad.getPassword());
		mongodb.setProddatabase( mongoPropertyLoad.getProddatabase());
		mongodb.setNestdatabase( mongoPropertyLoad.getNestdatabase());
		mongodb.setNlobdatabase(mongoPropertyLoad.getNlobdatabase());
		mongodb.setServerAddress( mongoPropertyLoad.getServerAddress());
		mongodb.setAuthdatabases( mongoPropertyLoad.getAuthdatabases());
        return mongodb;
    }	
	
}
