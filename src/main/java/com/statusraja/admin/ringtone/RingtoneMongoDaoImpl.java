package com.statusraja.admin.ringtone;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.statusraja.admin.constant.CollectionsConstant;
import com.statusraja.admin.mongo.MongoDBUtil;
import com.statusraja.admin.vo.FileDetailsVo;

@Repository
public class RingtoneMongoDaoImpl implements RingtoneMongoDao {

	private static final Logger logger = LoggerFactory.getLogger(RingtoneMongoDaoImpl.class);

	@Autowired
	MongoDBUtil mongoDBUtil;
	//private Gson 8 = new Gson();

	private static final String FILE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|pdf|xls))$)";

	@Override
	public void insertRecordInMongo(FileDetailsVo fileDetailsVo) {
		MongoCollection<Document> coll = null;
		coll = mongoDBUtil.getNestCollection(CollectionsConstant.MASTER_COLLECTION);

		Document masterDoc = new Document();
		masterDoc.put("srid", fileDetailsVo.getSrid());
		masterDoc.put("type", fileDetailsVo.getType());
		masterDoc.put("status", fileDetailsVo.getFileStatus());
		masterDoc.put("shortname", fileDetailsVo.getFileshortname());
		masterDoc.put("fullname", fileDetailsVo.getFilefullname());
		masterDoc.put("createddate", fileDetailsVo.getCreateddate());
		masterDoc.put("updateddate", fileDetailsVo.getCreateddate());
		coll.insertOne(masterDoc);
		logger.info(" ringtone master inserted .....");

		logger.info("---------------------------------------------");

		Document descDoc = new Document();
		descDoc.put("srid", fileDetailsVo.getSrid());
		descDoc.put("description", fileDetailsVo.getDescription());
		descDoc.put("language", fileDetailsVo.getLanguage());
		descDoc.put("createddate", fileDetailsVo.getCreateddate());
		descDoc.put("updateddate", fileDetailsVo.getCreateddate());
		coll = mongoDBUtil.getNestCollection(CollectionsConstant.DESCRIPTION_COLLECTION);
		coll.insertOne(descDoc);
		logger.info(" ringtone description inserted .....");

		logger.info("---------------------------------------------");

		Document fomatsDoc = new Document();
		fomatsDoc.put("formatid", 1);
		fomatsDoc.put("srid", fileDetailsVo.getSrid());
		fomatsDoc.put("url", fileDetailsVo.getFile_url());
		fomatsDoc.put("filename", fileDetailsVo.getFilename());
		fomatsDoc.put("file_duration", fileDetailsVo.getFile_duration());
		fomatsDoc.put("extension", fileDetailsVo.getExtension());
		fomatsDoc.put("createddate", fileDetailsVo.getCreateddate());
		fomatsDoc.put("updateddate", fileDetailsVo.getCreateddate());
		coll = mongoDBUtil.getNestCollection(CollectionsConstant.FORMATS_COLLECTION);
		coll.insertOne(fomatsDoc);
		logger.info(" ringtone formats inserted .....");

		logger.info("---------------------------------------------");

		Document ratingDownloadDoc = new Document();
		ratingDownloadDoc.put("srid", fileDetailsVo.getSrid());
		ratingDownloadDoc.put("rating", 0);
		ratingDownloadDoc.put("likes", 0);
		ratingDownloadDoc.put("downloadcount", 0);
		ratingDownloadDoc.put("dislike", 0);
		ratingDownloadDoc.put("createddate", fileDetailsVo.getCreateddate());
		ratingDownloadDoc.put("updateddate", fileDetailsVo.getCreateddate());
		coll = mongoDBUtil.getNestCollection(CollectionsConstant.RATINGSANDDOWNLOADS_COLLECTION);
		coll.insertOne(ratingDownloadDoc);
		logger.info(" ringtone desc inserted .....");
		
	}

	public Integer getMaxSrid() {
		Integer maxSrid = null;
		MongoCollection<Document> coll = null;
		coll = mongoDBUtil.getNestCollection(CollectionsConstant.MASTER_COLLECTION);
		FindIterable<Document> iterable = coll.find().sort(new BasicDBObject("_id", -1)).limit(1);
		MongoCursor<Document> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			Document doc = iterator.next();
			logger.info("DB Max id ==> {} ", doc.getInteger("srid"));
			maxSrid = doc.getInteger("srid") + 1;
		}
		return maxSrid;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FileDetailsVo> getMasterDetailsList(String type) {
		List<FileDetailsVo> filesList = new ArrayList<>();
		MongoCollection<Document> coll = null;
		coll = mongoDBUtil.getNestCollection(CollectionsConstant.MASTER_COLLECTION);

		Document lookupObject = new Document();
		lookupObject.append("from", CollectionsConstant.FORMATS_COLLECTION);
		lookupObject.append("localField", "srid");
		lookupObject.append("foreignField", "srid");
		lookupObject.append("as", "formatsDoc");
		
		Document lookupDesc = new Document();
		lookupDesc.append("from", CollectionsConstant.DESCRIPTION_COLLECTION);
		lookupDesc.append("localField", "srid");
		lookupDesc.append("foreignField", "srid");
		lookupDesc.append("as", "descriptionDoc");
		
		List<Bson> aggregatepipeline =new ArrayList();
		aggregatepipeline.add(new Document("$lookup", lookupObject));
		aggregatepipeline.add(new Document("$lookup", lookupDesc));
		MongoCursor<Document> cursor =coll.aggregate(aggregatepipeline).allowDiskUse(true).iterator();
		Document fileDoc = null;
		FileDetailsVo fileDetailsVo = null;
		while (cursor.hasNext()) {
			fileDoc = cursor.next();
			fileDetailsVo = new FileDetailsVo();
			fileDetailsVo.setSrid(fileDoc.getInteger("srid"));
			fileDetailsVo.setFileshortname(fileDoc.getString("shortname"));
			fileDetailsVo.setFilefullname(fileDoc.getString("fullname"));
			fileDetailsVo.setFileStatus(fileDoc.getString("status"));
			fileDetailsVo.setCreateddate(fileDoc.getDate("createddate"));
			
			List<Document> formatList=(List<Document>) fileDoc.get("formatsDoc");
			Document formatDoc=formatList.get(0);
			fileDetailsVo.setFilename(formatDoc.getString("filename"));
			fileDetailsVo.setExtension(formatDoc.getString("extension"));
			
			List<Document> descList=(List<Document>) fileDoc.get("descriptionDoc");
			Document descDoc=descList.get(0);
			fileDetailsVo.setLanguage(descDoc.getString("language"));
			
			filesList.add(fileDetailsVo);
		}
		return filesList;
	}

}
