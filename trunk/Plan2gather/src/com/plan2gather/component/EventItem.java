package com.plan2gather.component;

//class for each item in sliding menu
public class EventItem {

	private String title;
	private String startTime;
	private String endTime;

	public EventItem() {
	}

	public EventItem(String title, String startTime, String endTime) {
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStartTime(String time) {
		this.startTime = time;
	}

	public void setEndTime(String time) {
		this.endTime = time;
	}
}