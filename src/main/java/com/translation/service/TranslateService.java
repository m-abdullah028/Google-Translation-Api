package com.translation.service;

import com.google.gson.JsonObject;

public class TranslateService {
	public JsonObject translateString(JsonObject requestJson) {
		if (requestJson.has("query") && !requestJson.get("query").getAsString().isEmpty() && requestJson.has("source")
				&& !requestJson.get("source").getAsString().isEmpty() && requestJson.has("target")
				&& !requestJson.get("target").getAsString().isEmpty()) {
			String query = requestJson.get("query").getAsString();
			String source = requestJson.get("source").getAsString();
			String target = requestJson.get("target").getAsString();
		}

	}
}
