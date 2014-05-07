package com.plan2gather.component;

//class for each item in sliding menu
public class EventItem {

	private String title;
	private String startTime;
	private String endTime;
	private String description;
	// private String repetition;
	private String location;

	public EventItem() {
	}

	public EventItem(String title, String startTime, String endTime) {
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = null;
		// this.repetition = null;
		this.location = null;
	}

	public EventItem(String title, String startTime, String endTime,
			String desc, String place) {
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = desc;
		// this.repetition = repeat;
		this.location = place;
	}

	public String getTitle() {
		return this.title;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public String getDescription() {
		return this.description;
	}

	/*
	 * public String getRepetition() { return this.repetition; }
	 */

	public String getLocation() {
		return this.location;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStartTime(String time) {
		this.startTime = time;
	}

	public void setEndTime(String time) {
		this.endTime = time;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	/*
	 * public void setRepetition(String repeat) { this.repetition = repeat; }
	 */

	public void setLocation(String place) {
		this.location = place;
	}
}