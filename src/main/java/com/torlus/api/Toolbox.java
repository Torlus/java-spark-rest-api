package com.torlus.api;

import spark.Request;
import spark.Response;

public class Toolbox {
	public static boolean jsonIn(Request req) {
		return "application/json".equalsIgnoreCase(req.contentType());
	}
	public static Response jsonOut(Response res) {
		res.type("application/json");
		return res;
	}
	public static Response cors(Response res) {
		res.header("Access-Control-Allow-Origin", "*");
		return res;
	}
	public static Response options(Response res) {
		res.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		res.header("Accept", "application/json");		
		return res;
	}
}