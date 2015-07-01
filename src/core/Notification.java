package core;

import java.util.Date;

public class Notification {
	private Date date;
	private String message;
	private int type; //0 - System message, 1 - Room invite, 2 - Friend add
	private boolean seen;
	private long milisec;
	public Notification() {
		date = new Date();
		milisec = System.currentTimeMillis();
		type = 0;
	}
	public Date getDate() {
		return date;
	}
	public long getMillis() {
		return milisec;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSeen() {
		return seen;
	}
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	
}
