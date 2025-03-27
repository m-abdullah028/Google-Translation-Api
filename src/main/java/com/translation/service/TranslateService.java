package com.translation.service;

import com.google.api.client.util.Value;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.gson.JsonObject;

public class TranslateService {
	@Value("${api.key}")
	private String apiKey;

	public JsonObject translateString(JsonObject requestJson) {
		JsonObject responseJO = new JsonObject();
		JsonObject data = new JsonObject();
		if (requestJson.has("query") && !requestJson.get("query").getAsString().isEmpty() && requestJson.has("source")
				&& !requestJson.get("source").getAsString().isEmpty() && requestJson.has("target")
				&& !requestJson.get("target").getAsString().isEmpty()) {
			try {
				String query = requestJson.get("query").getAsString();
				String source = requestJson.get("source").getAsString();
				String target = requestJson.get("target").getAsString();

				// Initialize the Translate service
				Translate translate = TranslateOptions.newBuilder().setApiKey(apiKey).build().getService();

				// Translate to language
				com.google.cloud.translate.Translation translation = translate.translate(query,
						Translate.TranslateOption.sourceLanguage(source),
						Translate.TranslateOption.targetLanguage(target));

				data.addProperty("translatedText", translation.getTranslatedText());

				responseJO.addProperty("status", "success");
				responseJO.add("data", data);

			} catch (Exception e) {
				responseJO.addProperty("status", "error");
				responseJO.addProperty("message", "Translation failed: " + e.getMessage());
			}
		} else {
			responseJO.addProperty("status", "error");
			responseJO.addProperty("message", "Invalid request. 'query', 'source', and 'target' are required.");
		}
		return responseJO;

	}
}
