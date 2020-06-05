package com.statusraja.admin.mongo;


import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

@Service("nestMongoDBUtil")
public class MongoDBUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(MongoDBUtil.class);
	
	private static MongoClient mongoClient;
	private   String user;
	private   String password;
	private   String nestdatabase;
	private   String serverAddress;
	private   String proddatabase;
	private String nlobdatabase;
	private String authdatabases;
	public static TimeZone timeZone = TimeZone.getDefault();
	private static Properties prop = new Properties();
	
	
	
	public String getAuthdatabases() {
		return authdatabases;
	}

	public void setAuthdatabases(String authdatabases) {
		this.authdatabases = authdatabases;
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

	public MongoClient getInstance() throws UnknownHostException{
      
		
		if(mongoClient != null){
        	return mongoClient;
        }
		String[] serverAddressList = StringUtils.split(serverAddress, ",");
			List<ServerAddress> addressList = new ArrayList<ServerAddress>();
			for (int i = 0; i < serverAddressList.length; i++) {
				String[] serverdetails = StringUtils.split(serverAddressList[i], ":");
				if(serverdetails.length == 2)
					addressList.add(new ServerAddress(serverdetails[0],Integer.parseInt(serverdetails[1])));
				else
					addressList.add(new ServerAddress(serverdetails[0]));
			}
			
			if(StringUtils.isNotBlank(user) && StringUtils.isNotBlank(password)){
				
				final String[] dbtoAuth = StringUtils.split(authdatabases, ",");
			       final List<MongoCredential> mongoCred = new ArrayList<MongoCredential>();
			       for (int i = 0; i < dbtoAuth.length; i++) {
			        mongoCred.add(MongoCredential.createCredential(user, dbtoAuth[i], password.toCharArray()));
			    }
			       mongoClient = new MongoClient(addressList,mongoCred);
				
				
				/*MongoCredential mongoCredential =  null;
	    		mongoCredential = MongoCredential.createCredential(user, nestdatabase, password.toCharArray());
	    		//mongoClient = new MongoClient(new ServerAddress(serverAddress),Arrays.asList(mongoCredential));
	    		mongoClient = new MongoClient(addressList,Arrays.asList(mongoCredential));*/
	    		//com.mongodb.ReadPreference.primaryPreferred();
	    	}else{
	    		mongoClient = new MongoClient(addressList);
	    	}
			/*BSON.addEncodingHook(DateTime.class, new JodaTimeTransformer());
			BSON.addDecodingHook(Date.class, new JodaTimeTransformer());
			BSON.addDecodingHook(Timestamp.class,new JodaTimeTransformer());
			//BSON.addDecodingHook(java.sql.Date.class,new JodaTimeTransformer());
*/			mongoClient.setWriteConcern(WriteConcern.SAFE);
			return mongoClient;
    }
	
	public static String convertObjectToJson(Object vo){
		ObjectMapper jsonMapper = new ObjectMapper();
		String jsonString = "";
		
		try {
			jsonString = jsonMapper.writeValueAsString(vo);
		} catch (JsonGenerationException e) {
			logger.info(new Date() + ": Error in converting the object to json string" + e.getMessage());
		} catch (JsonMappingException e) {
			logger.info(new Date() + ": Error in converting the object to json string" + e.getMessage());
		} catch (IOException e) {
			logger.info(new Date() + ": Error in converting the object to json string" + e.getMessage());
		}
		return jsonString;
	}

	/*public void saveDataToMongo(PayLoad...loads){
		logger.info(" Received request to save data to collection with input as payloads " +loads.length);
		for (int i = 0; i < loads.length; i++) {
			Document  dbo = (Document ) loads[i].getDocument();
			try {				
				MongoCollection<Document>  collection = getMongoCollection(loads[i].getCollection()); //3 driver
					logger.info(" initialized mongo with collection  " +loads[i].getCollection());
				collection.insertOne(dbo);
					logger.info(" saved the data to the collection ");
			}catch(MongoException e){ 
				e.printStackTrace();
				logger.error(" mongo exception "+e.getCode());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}*/
	MongoDatabase getMongoDB(){
		return getMongoDB(nestdatabase);
	}
	
	MongoDatabase getMongoNextoryDB(){
		return getMongoDB(proddatabase);
	}
	
	public MongoDatabase getMongoDB(String str){
		try{
			return getInstance().getDatabase(str);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
		return null;
	}
	public  MongoCollection<Document> getMongoCollection(String alternativedatabase,String collectionName){
		MongoCollection<Document>   collection =null;				
		collection = getMongoDB(alternativedatabase).getCollection(collectionName);		
		return collection;		
	}
	public  MongoCollection<Document> getNestCollection(String collectionName){
		MongoCollection<Document>   collection =null;				
		collection = getMongoDB(nestdatabase).getCollection(collectionName);		
		return collection;		
	}
	
	public  MongoIterable<String> getNestCollections(){
		MongoCollection<Document>   collection =null;			
		MongoDatabase db = getMongoDB(nestdatabase);
		 MongoIterable<String> collections = db.listCollectionNames();
		return collections;		
	}
	
	public  MongoCollection<Document> getNextoryCollection(String collectionName){
		MongoCollection<Document>   collection =null;				
		collection = getMongoDB(proddatabase).getCollection(collectionName);		
		return collection;		
	}
	
	
	public  MongoCollection<Document> getNlobCollection(String collectionName){
		MongoCollection<Document>   collection =null;				
		collection = getMongoDB(nlobdatabase).getCollection(collectionName);		
		return collection;		
	}
}
	/*class JodaTimeTransformer implements org.bson.Transformer {

	    public Object transform(Object o) {
	        if(o instanceof DateTime) {
	            return ((DateTime)o).toDate();
	        }
	        else if(o instanceof Timestamp){
	        	return new DateTime(((Timestamp)o).getTime()).toDate();
	        }
	        else if(o instanceof Date) {
	            return new DateTime((Date) o);
	        }
	        else if(o instanceof java.sql.Date) {
	            return new DateTime((java.sql.Date) o);
	        }
	        throw new IllegalArgumentException("JodaTimeTransformer can only be used with DateTime or Date");
	    }
	    
	  

	}*/