package com.statusraja.admin.mongo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class AggregationPipeLine {

	private final List<Document> stages = new ArrayList<Document>();
    
	
	Document out = null;
	String collectionname = null;
	String productdatabase = null;
	Logger logger = Logger.getLogger(AggregationPipeLine.class);
	
	
	
	public String getCollectionname() {
		return collectionname;
	}

	public void setCollectionname(String collectionname) {
		this.collectionname = collectionname;
	}

	public String getProductdatabase() {
		return productdatabase;
	}

	public void setProductdatabase(String productdatabase) {
		this.productdatabase = productdatabase;
	}

	public AggregationPipeLine(String collectionname) {
		this.collectionname = collectionname;
	}
	
	public AggregationPipeLine(String collectionname, String productdatabase) {
		this.collectionname = collectionname;
		this.productdatabase = productdatabase;
	}
	
	public AggregationPipeLine(){}
	
	/*
	public <U> Iterator<U> aggregate(Class<U> target) {
		
		return null;
	}

	
	public <U> Iterator<U> aggregate(Class<U> target, AggregationOptions options) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <U> Iterator<U> aggregate(Class<U> target,
			AggregationOptions options, ReadPreference readPreference) {
		// TODO Auto-generated method stub
		return null;
	}
*/
/*	
	public <U> Iterator<U> aggregate(String collectionName, Class<U> target,
			AggregationOptions options, ReadPreference readPreference) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public NestAggregationPipeLine geoNear(GeoNear geoNear) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
	public List<Document> getAggregationStages(){
		if(this.out!=null)
			this.stages.add(out);
		String aggregateString = stages.stream().sequential().map(document->document.toJson()).collect(Collectors.joining(",")); 
		logger.info("Aggregation pipe line  "+aggregateString);
		return stages;
	}
	
	public AggregateIterable<Document> aggregate(MongoDatabase database){
		if(this.out!=null)
			this.stages.add(out);
		if(logger.isDebugEnabled()){
			String aggregateString = stages.stream().sequential().map(document->document.toJson()).collect(Collectors.joining(",")); 
			logger.debug(new Date() + ": Aggregation pipe line " + "["+aggregateString+"]");
			
		}
		
		MongoCollection<Document> collection = database.getCollection(collectionname);
		return collection.aggregate(stages).allowDiskUse(true);		
	}
	public AggregationPipeLine group(Document groupedDoc) {
		Document document = new Document("$group",groupedDoc);
		stages.add(document);
		return this;
	}
	public AggregationPipeLine out(String outputcollection) {
		this.out = new Document("$out", outputcollection);
		return this;
	}
		
	public AggregationPipeLine limit(int count) {
		stages.add(new Document("$limit", count));
		return this;
	}

	// this should not be added to the list as this should be the last element in the pipeline array
	public AggregationPipeLine lookup(String from, String localField,String foreignField, String as) {
		Document lookupDefinition = Document.parse("{from:'"+from+"',localField:'"+localField+"',foreignField:'"+foreignField+"',as:'"+as+"'}");
		stages.add(new Document("$lookup",lookupDefinition));		
		return this;
	}

	
	public AggregationPipeLine match(Document matchdocument) {
		Document document = new Document("$match",matchdocument);
		stages.add(document);
		return this;
	}
		
	public AggregationPipeLine project(String... field) {
		Document document = new Document();
		Bson projections = Projections.include(field);
		document.append("$project", projections);
		stages.add(document);
		return null;
	}
	public AggregationPipeLine projectParse(Document doc) {
		Document document = new Document();
		//Bson projections = Projections.include(field);
		document.append("$project", doc);
		stages.add(document);
		return null;
	}

	
	public AggregationPipeLine skip(int count) {
		stages.add(new Document("$skip", count));
		return this;
	}
	public AggregationPipeLine sortDesc(String... fieldNames) {
		Document sort = new Document("$sort",Sorts.descending(fieldNames));
		stages.add(sort);
		return this;
	}
	
	public AggregationPipeLine sortAsc(String... fieldNames) {
		Document sort = new Document("$sort",Sorts.ascending(fieldNames));
		stages.add(sort);
		return this;
	}

	
	public AggregationPipeLine unwind(String field) {
		Document unwind = new Document("$unwind","$"+field);
		stages.add(unwind);
		return this;
	}
	public AggregationPipeLine redact(Document redactDocument) {
		Document document = new Document("$redact",redactDocument);
		stages.add(document);
		return this;
	}

}
