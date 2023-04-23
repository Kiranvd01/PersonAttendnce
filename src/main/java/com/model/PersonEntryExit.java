package com.model;

public class PersonEntryExit {
	private int id;
	private String etime;
	private String xtime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getXtime() {
		return xtime;
	}

	public void setXtime(String xtime) {
		this.xtime = xtime;
	}

	@Override
	public String toString() {
		return "PersonData [id=" + id + ", etime=" + etime + ", xtime=" + xtime + "]";
	}

	public PersonEntryExit(int id, String etime, String xtime) {
		super();
		this.id = id;
		this.etime = etime;
		this.xtime = xtime;
	}

	public PersonEntryExit() {
		super();
		// TODO Auto-generated constructor stub
	}

}
