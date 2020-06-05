package com.statusraja.admin.mongo.dao;

import java.util.HashMap;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public interface GenericMongoDAO {

public  List<String>  getCollectionNames(String dbName);
	
	public MongoDatabase getMongoDatabase();
	
	public  <TDocument> MongoCollection<TDocument> getDbCollectionInstance(String dbName, String collectionName);
	
	public <TDocument> long count(MongoCollection<TDocument> collection);
	
	 public <TDocument> long count(MongoCollection<TDocument> collection,Bson filter);
	
	 public <TDocument> FindIterable<TDocument> find(MongoCollection<TDocument> collection) ;
	
	 public <TResult,TDocument>MongoCursor<TResult> find(MongoCollection<TDocument> collection,Document filter);
	
	 public <TDocument> FindIterable<TDocument> find( MongoCollection<TDocument> collection,Bson filter) ;
	 
	 public <TDocument> FindIterable<TDocument> find(MongoCollection<TDocument> collection, Bson filter, int skip, int limit,Bson sort);
	
	 public <TResult,TDocument> FindIterable<TResult> find(MongoCollection<TDocument> collection,Bson filter, Class<TResult> resultClass);
	
	 public <TDocument> AggregateIterable <TDocument> aggregate(MongoCollection<TDocument> collection,List<? extends Bson> pipeline);
	 
	 public <TDocument> AggregateIterable <TDocument> aggregate(MongoCollection<TDocument> collection,List<? extends Bson> pipeline,Boolean allowDiskUse);
	
	 public <TDocument> AggregateIterable<Document> aggregate( MongoDatabase mongoDatabase,AggregationPipeLine aggregationPipeLine) ;
	
	 public  <TDocument> AggregateIterable<Document> aggregate( MongoDatabase mongoDatabase,AggregationPipeLine aggregationPipeLine,Boolean allowDiskUse);
	 
	 
	 default  public <TDocument> TDocument findOneAndUpdate(MongoCollection<TDocument> collection,Bson filter,Bson update) {
			return   collection.findOneAndUpdate(filter, update);
		}
	
	 default  public <TDocument> TDocument findOneAndUpdate(MongoCollection<TDocument> collection,Bson filter,Bson update,FindOneAndUpdateOptions options) {
		 return   collection.findOneAndUpdate(filter, update,options);
	 }
	 
	 default public <TDocument> TDocument findOneAndReplace(MongoCollection<TDocument> collection,Bson filter, TDocument replacement) {
		 return   collection.findOneAndReplace(filter, replacement);
	 }
		
	 default public <TDocument> TDocument findOneAndDelete(MongoCollection<TDocument> collection,Bson filter) {
		 return   collection.findOneAndDelete(filter);
	 }
		
	 default public <TDocument> void insertOne(MongoCollection<TDocument> collection,TDocument document) {
		 collection.insertOne(document);
	 }
	 
	 default public <TDocument> void insertMany(MongoCollection<TDocument> collection,List<? extends TDocument> documents) {
		 collection.insertMany(documents);
	 }
	 
	 default public <TDocument> UpdateResult updateOne(MongoCollection<TDocument> collection,Bson filter, Bson update) {
			return   collection.updateOne(filter, update);
	}
	 
	 default public <TDocument> UpdateResult updateMany(MongoCollection<TDocument> collection,Bson filter, Bson update) {
			return   collection.updateMany(filter, update);
		}

	 default public <TDocument> DeleteResult  deleteOne(MongoCollection<TDocument> collection,Bson filter) {
			return   collection.deleteOne(filter);
		}
		
	 default public <TDocument> DeleteResult  deleteMany(MongoCollection<TDocument> collection,Bson filter) {
		 return   collection.deleteMany(filter);
	 }
}
