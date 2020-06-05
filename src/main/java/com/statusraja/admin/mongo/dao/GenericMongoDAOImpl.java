package com.statusraja.admin.mongo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.statusraja.admin.mongo.MongoDBUtil;

@Repository("genericMongoDAO")
public class GenericMongoDAOImpl implements GenericMongoDAO {

	@Autowired
	MongoDBUtil nestMongoDBUtil;
	
	private static final Logger logger = LoggerFactory.getLogger(GenericMongoDAOImpl.class);
	
	private MongoDatabase mongoDatabase;
	private Map<String,MongoCollection<Document>> collectionMap = new HashMap<String,MongoCollection<Document>>();
	private Map<String,MongoDatabase> mongoDatabaseMap = new HashMap<String,MongoDatabase>();

	public MongoDatabase getMongoDatabase() {
		return mongoDatabase;
	}
	
	@Override
	public List<String> getCollectionNames(String dbName) {
		MongoDatabase tmpMongoDatabase = nestMongoDBUtil.getMongoDB(dbName);
		MongoIterable<String> collectionNamesIterable = tmpMongoDatabase.listCollectionNames();
		List<String> tmpCollectionNames = new ArrayList<>();
		for(String tmpCollectionName : collectionNamesIterable){
			tmpCollectionNames.add(tmpCollectionName);
		}
		return tmpCollectionNames;
	}

	@SuppressWarnings("unchecked")
	@Override
	public  <TDocument> MongoCollection<TDocument> getDbCollectionInstance(String dbName, String collectionName) {
		MongoCollection<Document> collection = collectionMap.get(collectionName);
		if(null == collection){
			collection = nestMongoDBUtil.getMongoCollection(dbName, collectionName);
			collectionMap .put(collectionName,collection);
		}
		mongoDatabase = mongoDatabaseMap.get(dbName);
		if(null == mongoDatabase){
			mongoDatabase = nestMongoDBUtil.getMongoDB(dbName);
			mongoDatabaseMap.put(dbName, mongoDatabase);
		}
		return (MongoCollection<TDocument>) collection;
	}

	@Override
	public <TDocument> long count(MongoCollection<TDocument> collection) {
		return collection.count();
	}
	
	@Override
	public <TDocument> long count(MongoCollection<TDocument> collection,Bson filter) {
		return collection.count(filter);
	}

	@Override
	public  <TDocument> FindIterable<TDocument> find(MongoCollection<TDocument> collection) {
		return (FindIterable<TDocument>) collection.find();
	}

	@Override
	public <TDocument> FindIterable<TDocument> find(MongoCollection<TDocument> collection,Bson filter) {
		return (FindIterable<TDocument>) collection.find(filter);
	}
	
	@Override
	public <TDocument> FindIterable<TDocument> find(MongoCollection<TDocument> collection, Bson filter, int skip,int limit, Bson sort) {
		return collection.find(filter).skip(skip).limit(limit).sort(sort);
	}

	@Override
	public <TResult, TDocument> FindIterable<TResult> find(MongoCollection<TDocument> collection,Bson filter,Class<TResult> resultClass) {
		return collection.find(filter, resultClass);
	}

	@Override
	public <TDocument> AggregateIterable<TDocument> aggregate(MongoCollection<TDocument> collection,List<? extends Bson> pipeline) {
		return (AggregateIterable<TDocument>) collection.aggregate(pipeline);
	}
	
	@Override
	public <TDocument> AggregateIterable<TDocument> aggregate(MongoCollection<TDocument> collection, List<? extends Bson> pipeline, Boolean allowDiskUse) {
		return (AggregateIterable<TDocument>) collection.aggregate(pipeline).allowDiskUse(allowDiskUse);
	}
	
	@Override
	public <TDocument> AggregateIterable<Document> aggregate( MongoDatabase mongoDatabase,AggregationPipeLine aggregationPipeLine) {
		return aggregationPipeLine.aggregate(mongoDatabase);
	}
	
	@Override
	public <TDocument> AggregateIterable<Document> aggregate( MongoDatabase mongoDatabase,AggregationPipeLine aggregationPipeLine, Boolean allowDiskUse) {
		return aggregationPipeLine.aggregate(mongoDatabase).allowDiskUse(allowDiskUse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <TResult,TDocument> MongoCursor<TResult> find(MongoCollection<TDocument> collection,Document filter) {
		return  (MongoCursor<TResult>) collection.find(filter).iterator();
	}

	
}
