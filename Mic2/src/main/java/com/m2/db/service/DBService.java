package com.m2.db.service;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.m2.db.DBContext;
import com.m2.utils.JsonUtil;
import com.mongodb.client.MongoCollection;

public class DBService {
	public static void addOne(String jsonUser, String id) throws Exception {
		MongoCollection<Document> collection = DBContext.fetchCollection("data", "Users", Document.class);
		Document found = (Document) collection.find(new Document("_id", id)).first();
		
		if (found != null) {
			System.out.println("Found User");
			
			Bson updatevalue = new Document("middleName", JsonUtil.fromJsontoUser(jsonUser).getMiddleName());
			Bson updateoperation = new Document("$set", updatevalue);
			collection.updateOne(found, updateoperation);
			System.out.println("User Updated");
		}
	}
}
