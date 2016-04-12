package com.torlus.api.resources;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.torlus.api.Resource;

public class User extends Resource {
	public String handle;
	
	public String firstName;
	public String lastName;
	
	@JsonProperty("groups")
	public List<Group> groups;

}
