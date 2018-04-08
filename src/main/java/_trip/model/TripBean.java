package _trip.model;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




public class TripBean {
	
	
	private String memberid;
	private String viewid;
	private String name;
	private String address;
	private String web;
	private String phone;
	private String main;
	private String imagename;
	private java.sql.Timestamp tdate;

	

	public TripBean(String memberid, String viewid, String name, String address, String web, String phone, String main,
			String imagename, Timestamp tdate) {
	
		this.memberid = memberid;
		this.viewid = viewid;
		this.name = name;
		this.address = address;
		this.web = web;
		this.phone = phone;
		this.main = main;
		this.imagename = imagename;
		this.tdate = tdate;
	}

	

	public void getConnection() {

	}

	public java.sql.Timestamp getTdate() {
		return tdate;
	}

	public void setTdate(java.sql.Timestamp tdate) {
		this.tdate = tdate;
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat();

	public static java.util.Date convertDate(String temp) {
		java.util.Date result = new java.util.Date();

		try {
			result = sdf.parse(temp);
		} catch (ParseException e) {
			result = null;
			e.printStackTrace();
		}
		return result;
	}

	public String getViewid() {
		return viewid;
	}

	public void setViewid(String viewid) {
		this.viewid = viewid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	

}
	