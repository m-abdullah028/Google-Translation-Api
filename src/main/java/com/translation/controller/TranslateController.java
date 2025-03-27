package com.translation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.translation.service.TranslateService;

@RestController
public class TranslateController {
	@Autowired
	private TranslateService translateService;
	Gson gson = new Gson();

	@RequestMapping(value = { "/translate" }, method = { RequestMethod.POST }, produces = { "application/json" })
	public ResponseEntity<String> translateProcess(@RequestBody String requestJson) {
		JsonObject request = (JsonObject) this.gson.fromJson(requestJson, JsonObject.class);

		JsonObject responseJson = translateService.translateString(request); // Call service method

		return new ResponseEntity<>(responseJson.toString(), HttpStatus.OK);
	}

}
