package com.m1.db.service;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.m1.db.DBContext;
import com.m1.user.User;
import com.m1.utils.JsonUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;

public class DBService {

	public static String getIdFromJsonBody(String jsonUser) throws Exception {
		return JsonUtil.fromJsontoUser(jsonUser).get_id();
	}

	public static void addFirstName(String jsonUser, String id) {
		try {
			MongoCollection<Document> collection = DBContext.fetchCollection("data", "Users", Document.class);
			User user = JsonUtil.fromJsontoUser(jsonUser);
			Document document = new Document("_id", id);
			document.put("firstName", user.getFirstName());
			collection.insertOne(document);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateFirstName(String jsonUser, String id) throws Exception {
		MongoCollection<User> collection = DBContext.fetchCollection("data", "Users", User.class);
		collection.updateOne(new Document("_id", id),
				Updates.set("firstName", JsonUtil.fromJsontoUser(jsonUser).getFirstName()));
	}

	public static void deleteFirstName(String id) {
		MongoCollection<Document> collection = DBContext.fetchCollection("data", "Users", Document.class);
		DBObject update = new BasicDBObject();
		update.put("$unset", new BasicDBObject("firstName", ""));
		collection.updateOne(new BasicDBObject("_id", id), (Bson) update);
	}
}