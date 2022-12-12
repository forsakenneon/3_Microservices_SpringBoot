package db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Updates;

import db.DBContext;
import lombok.var;
import user.User;
import user.utils.UserUtils;
import utils.JsonUtil;

public class DBService {
	public static List<User> getAll() throws Exception {
		MongoCursor<Document> cursor = DBContext.fetchCollectionCursor("data", "Users", User.class);
		var users = new ArrayList<User>();
		try {
			while (cursor.hasNext()) {
				users.add(JsonUtil.fromJsontoUser(cursor.next().toJson()));
			}
		} finally {
			cursor.close();
		}
		return users;
	}

	public static void addOne(String jsonUser) {
		try {
			MongoCollection<Document> collection = DBContext.fetchCollection("data", "Users", Document.class);
			User user = JsonUtil.fromJsontoUser(jsonUser);
			Document document = new Document("_id", UserUtils.generateId());
			Map<String, String> map = Map.of("firstName", user.getFirstName(), "middleName", user.getMiddleName(),
					"lastName", user.getLastName());

			document.putAll(map);
			collection.insertOne(document);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateOne(String jsonUser) {
		try {
			User user = JsonUtil.fromJsontoUser(jsonUser);
			String id = user.get_id();
			MongoCollection<User> collection = DBContext.fetchCollection("data", "Users", User.class);

			collection.updateOne(new Document("_id", id), Updates.set("firstName", user.getFirstName()));
			collection.updateOne(new Document("_id", id), Updates.set("middleName", user.getMiddleName()));
			collection.updateOne(new Document("_id", id), Updates.set("lastName", user.getLastName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteOne(String jsonUser) {
		try {
			DBContext.fetchCollection("data", "Users", User.class)
					.deleteOne(new Document("_id", JsonUtil.fromJsontoUser(jsonUser).get_id()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
