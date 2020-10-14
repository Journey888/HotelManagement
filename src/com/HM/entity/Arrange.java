package com.HM.entity;

import java.util.Date;

public class Arrange {
	private String  rno;
	private String size;
	private String rent;
	private String name;
	private String state;
	private Date startdate;
	private Date enddate;
	
	@Override
	public String toString() {
		return "Arrange [rno=" + rno + ", size=" + size + ", rent=" + rent + ", name=" + name + ", state=" + state
				+ ", startdate=" + startdate + ", enddate=" + enddate + "]";
	}

	public String getRno() {
		return rno;
	}

	public void setRno(String rno) {
		this.rno = rno;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	
	

}
