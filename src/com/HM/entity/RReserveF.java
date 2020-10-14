package com.HM.entity;

import java.util.Date;

public class RReserveF {
	
	private String  rno;
	private String name;
	private String idcard;
	private Date startdate;
	private Date enddate;
	private String size;
	private String rent;
	@Override
	public String toString() {
		return "RReserveF [rno=" + rno + ", name=" + name + ", idcard=" + idcard + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", size=" + size + ", rent=" + rent + "]";
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	
	
	
	

	
	
}
