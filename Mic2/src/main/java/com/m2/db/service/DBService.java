package com.m2.db.service;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.m2.db.DBContext;
import com.m2.user.User;
import com.m2.utils.JsonUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;

public class DBService {
	public static void addMiddleName(String jsonUser, String id) throws Exception {
		MongoCollection<Document> collection = DBContext.fetchCollection("data", "Users", Document.class);
		Document found = (Document) collection.find(new Document("_id", id)).first();

		if (found != null) {
			Bson updatevalue = new Document("middleName", JsonUtil.fromJsontoUser(jsonUser).getMiddleName());
			Bson updateoperation = new Document("$set", updatevalue);
			collection.updateOne(found, updateoperation);
		}
	}

	public static void updateMiddleName(String jsonUser, String id) throws Exception {
		MongoCollection<User> collection = DBContext.fetchCollection("data", "Users", User.class);
		collection.updateOne(new Document("_id", id),
				Updates.set("middleName", JsonUtil.fromJsontoUser(jsonUser).getMiddleName()));
	}

	public static void deleteMiddleName(String id) {
		MongoCollection<Document> collection = DBContext.fetchCollection("data", "Users", Document.class);
		DBObject update = new BasicDBObject();
		update.put("$unset", new BasicDBObject("middleName", ""));
		collection.updateOne(new BasicDBObject("_id", id), (Bson) update);
	}
}
