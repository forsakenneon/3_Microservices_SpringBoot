package utils;

import com.google.gson.Gson;

import user.User;

public class JsonUtil {
	public final static Gson gson = new Gson();

	public static User fromJsontoUser(String jsonstudent) throws Exception {
		return gson.fromJson(jsonstudent, User.class);
	}
}
