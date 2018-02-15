package com.ct;

public class Teacher {
	
	private String name;
	private String id;
	private String topic;
	private String time;

	public Teacher() {
		name = "";
		id = "";
		topic = "";
		time = "";
	}
	
	public Teacher(String name, String id, String topic, String time) {
		this.name = name;
		this.id = id;
		this.topic = topic;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getTopic() {
		return topic;
	}
	
	public String gettime() {
		return time;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public void settime(String time) {
		this.time = time;
	}
	
	@Override public String toString() {
		return id + "\t" + name + "\t" + topic + "\t" + time;
	}
}
