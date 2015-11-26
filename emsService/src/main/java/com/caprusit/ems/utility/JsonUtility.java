package com.caprusit.ems.utility;

import com.google.gson.Gson;

public class JsonUtility {
	public static String convertToJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
}
