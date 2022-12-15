package db.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCursor;

import db.DBContext;
import user.User;
import utils.JsonUtil;

@Repository
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
}