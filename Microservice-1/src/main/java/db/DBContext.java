package db;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

public class DBContext {
	private static final String MONGO_URI = "mongodb://localhost:27017/";

	public static <T> MongoCollection<T> fetchCollection(String dbName, String collectionName,
			Class<T> collectionType) {
		return MongoClients.create(MONGO_URI).getDatabase(dbName)
				.withCodecRegistry(CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
						CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())))
				.getCollection(collectionName, collectionType);
	}
}
