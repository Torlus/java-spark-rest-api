package com.torlus.api;

import static spark.Spark.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.torlus.api.resources.*;

public class Application {

	private static Application app;
	private static ObjectMapper om;

	public static Application app() {
		return app;
	}
	static {
		 app = new Application();
		 om = new ObjectMapper();
	}

	public static void main(String[] args) {

		Resource.OfType<User> users  = new Resource.OfType<>();
		Resource.OfType<Group> groups = new Resource.OfType<>();
		
		// port(4567);
		staticFileLocation("front-end");
				
		options("/users", (req, res) -> {
			Toolbox.options(res);
			Toolbox.cors(res);
			return "";
		});
		get("/users", (req, res) -> {
			Toolbox.jsonOut(res);
			Toolbox.cors(res);
			return om.writeValueAsString(users.all());
		});
		get("/users/:id", (req, res) -> {
			Toolbox.jsonOut(res);
			Toolbox.cors(res);
			User u = users.find(req.params(":id"));
			if (u == null) {
				res.status(404);
				return "";
			} else {
				return om.writeValueAsString(u);
			}
		});

	}

}
