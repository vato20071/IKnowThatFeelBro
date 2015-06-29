package core;

import java.util.Date;

public class Message {

	private String author;
	private String message;
	private Date date;
	
	public Message() {
		date = new Date();
	}
	
	public Date getDate() {
		return date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return author + ": " + message + "\t" + date.toString() + "\n"; 
	}
	
}
