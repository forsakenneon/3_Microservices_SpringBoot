package com.m3.db.service;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.m3.db.DBContext;
import com.m3.user.User;
import com.mongodb.client.MongoCollection;

public class DBService {
	public static void addLastName(User user) throws Exception {
		MongoCollection<Document> collection = DBContext.fetchCollection("data", "Users", Document.class);
		Document found = (Document) collection.find(new Document("_id", user.get_id())).first();

		if (found != null) {
			Bson updatevalue = new Document("lastName", user.getLastName());
			Bson updateoperation = new Document("$set", updatevalue);
			collection.updateOne(found, updateoperation);
		}
	}
}
