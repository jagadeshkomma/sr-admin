package com.statusraja.admin.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.statusraja.admin.constant.CollectionsConstant;
import com.statusraja.admin.vo.Categories;
import com.statusraja.admin.vo.Languages;

@Repository
public class GenericMongoDaoImpl implements GenericMongoDao {

	private static final Logger logger = LoggerFactory.getLogger(GenericMongoDaoImpl.class);

	@Autowired
	MongoDBUtil mongoDBUtil;
	//private Gson 8 = new Gson();

	@Override
	public List<Languages> getLanguageList() {
		List<Languages> languages = new ArrayList<>();
		MongoCursor<Document> cursor = null;
		MongoCollection<Document> coll=null;
		coll = mongoDBUtil.getNestCollection(CollectionsConstant.LANGUAGES);
		cursor =coll.find().iterator();
		Languages language = null;
		while(cursor.hasNext()){
			Document fileDoc = cursor.next();
			language = new Languages();
			language.setLangid(fileDoc.getInteger("langid"));
			language.setName(fileDoc.getString("name"));
			languages.add(language);
		}
		return languages;
	}


	@Override
	public List<Categories> getCategories(String type) {
		List<Categories> categories = new ArrayList<>();
		MongoCursor<Document> cursor = null;
		MongoCollection<Document> coll = null;
		Document match = new Document();
		match.put("type", type);
		coll = mongoDBUtil.getNestCollection(CollectionsConstant.CATEGORIES);
		cursor = coll.find(match).iterator();
		Categories category = null;
		while (cursor.hasNext()) {
			Document fileDoc = cursor.next();
			category = new Categories();
			category.setCategoryid(fileDoc.getInteger("categoryid"));
			category.setName(fileDoc.getString("name"));
			category.setType(fileDoc.getString("type"));
			categories.add(category);
		}
		return categories;
	}

}
