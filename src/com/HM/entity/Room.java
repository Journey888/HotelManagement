package com.HM.entity;

public class Room {
	
	private String rno;
	private String size;
	private String rent;
	private String state;
	@Override
	public String toString() {
		return "Room [rno=" + rno + ", size=" + size + ", rent=" + rent + ", state=" + state + "]";
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
	
	
	
	
	

}
