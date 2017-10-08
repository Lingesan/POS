package com.pos.beans;

public class Message {

	private String status;
	private String content;
	

	public Message(String status, String content) {
		super();
		this.status = status;
		this.content = content;
	}

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
