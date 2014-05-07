package com.plan2gather.component;

public class UserItem {
	private String id;
	private String Name;

	// boolean to set visiblity of the counter
	public UserItem() {
	}

	public UserItem(String id, String name) {
		this.id = id;
		this.Name = name;
	}

	public String getID() {
		return this.id;
	}

	public String getName() {
		return this.Name;
	}

	public void setID(String _id) {
		this.id = _id;
	}

	public void setName(String _name) {
		this.Name = _name;
	}

}