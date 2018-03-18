package trip.model;

import java.sql.Blob;
import java.sql.Date;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TripBean {
	private String memberid;
	private String viewid;
	private String place;
	private String name;
	private String date;
	private String type;
	private String main;
	private String image;
	private java.sql.Timestamp tdate;

	public TripBean() {

	}

	public TripBean(String memberid, String viewid, String place, String name, String date, String type, String main,
			String image, Timestamp tdate) {
	
		this.memberid = memberid;
		this.viewid = viewid;
		this.place = place;
		this.name = name;
		this.date = date;
		this.type = type;
		this.main = main;
		this.image = image;
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

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getViewid() {
		return viewid;
	}

	public void setViewid(String viewid) {
		this.viewid = viewid;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
	