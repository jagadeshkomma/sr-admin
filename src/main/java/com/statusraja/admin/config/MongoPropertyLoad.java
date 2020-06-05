package com.statusraja.admin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mongoPropertyLoad")
public class MongoPropertyLoad {

	public static final Logger logger = LoggerFactory.getLogger(MongoPropertyLoad.class);
	
	@Value("${mongo.user}")
	private   String user;
	
	@Value("${mongo.password}")
	private   String password;
	
	@Value("${mongo.database}")
	private   String nestdatabase;
	
	@Value("${mongo.host}")
	private   String serverAddress;
	
	@Value("${mongo.database.product}")
	private   String proddatabase;
	
	@Value("${mongo.database.nlob}")
	private String nlobdatabase;
	
	@Value("${mongo.auth.databases}")
	private String authdatabases;

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNestdatabase() {
		return nestdatabase;
	}

	public void setNestdatabase(String nestdatabase) {
		this.nestdatabase = nestdatabase;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getProddatabase() {
		return proddatabase;
	}

	public void setProddatabase(String proddatabase) {
		this.proddatabase = proddatabase;
	}

	public String getNlobdatabase() {
		return nlobdatabase;
	}

	public void setNlobdatabase(String nlobdatabase) {
		this.nlobdatabase = nlobdatabase;
	}

	public String getAuthdatabases() {
		return authdatabases;
	}

	public void setAuthdatabases(String authdatabases) {
		this.authdatabases = authdatabases;
	}

	

}
