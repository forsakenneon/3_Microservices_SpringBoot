package db.service;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import db.DBContext;
import user.User;
import user.utils.UserUtils;
import utils.JsonUtil;

public class DBService {
	public static void addOne(String jsonUser) {
		try {
			MongoCollection<Document> collection = DBContext.fetchCollection("data", "Students", Document.class);
			User student = JsonUtil.fromJsontoUser(jsonUser);
			Document document = new Document("_id", UserUtils.generateId());
			Map<String, String> map = Stream
					.of(new String[][] { { "firstName", student.getFirstName() },
							{ "middleName", student.getMiddleName() }, { "lastName", student.getLastName() }, })
					.collect(Collectors.toMap(data -> data[0], data -> data[1]));

			document.putAll(map);
			collection.insertOne(document);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
