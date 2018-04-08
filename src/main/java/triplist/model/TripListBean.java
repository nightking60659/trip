package triplist.model;

import java.sql.Date;

public class TripListBean {
	private String viewName;
	private java.sql.Date  StartTime;
	private java.sql.Date  endTime;
	private String tripType;
	private String tripname;
	private int tripid;
	private int tripday;
	private int viewid;
	
	
	
	
	public TripListBean() {
		
	}
	public TripListBean(String viewName, Date startTime, Date endTime, String tripType, String tripname, int tripid,
			int tripday, int viewid) {
	
		this.viewName = viewName;
		this.StartTime = startTime;
		this.endTime = endTime;
		this.tripType = tripType;
		this.tripname = tripname;
		this.tripid = tripid;
		this.tripday = tripday;
		this.viewid = viewid;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public java.sql.Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(java.sql.Date startTime) {
		StartTime = startTime;
	}
	public java.sql.Date getEndTime() {
		return endTime;
	}
	public void setEndTime(java.sql.Date endTime) {
		this.endTime = endTime;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getTripname() {
		return tripname;
	}
	public void setTripname(String tripname) {
		this.tripname = tripname;
	}
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	public int getTripday() {
		return tripday;
	}
	public void setTripday(int tripday) {
		this.tripday = tripday;
	}
	public int getViewid() {
		return viewid;
	}
	public void setViewid(int viewid) {
		this.viewid = viewid;
	}
	
}
