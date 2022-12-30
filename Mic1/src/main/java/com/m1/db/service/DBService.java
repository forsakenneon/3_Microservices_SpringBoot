package com.m1.db.service;

import org.bson.Document;

import com.m1.db.DBContext;
import com.m1.user.User;
import com.m1.utils.JsonUtil;
import com.mongodb.client.MongoCollection;

public class DBService {
	public static void addOne(String jsonUser, String id) {
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
}