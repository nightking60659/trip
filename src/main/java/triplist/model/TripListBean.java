package triplist.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tripAll.model.TripAllBean;
import tripview.model.TripViewBean;

@Entity
@Table(name="TravelList")
@IdClass(TripListPK.class)
public class TripListBean {
	
	@Column(name="viewName")
	private String viewName;
	@Column(name="StartTime")
	private java.sql.Date  StartTime;
	@Column(name="endTime")
	private java.sql.Date  endTime;
	@Column(name="tripType")
	private String tripType;
	@Column(name="tripname")
	private String tripname;
	
	private TripAllBean tripAllBean;
	private TripViewBean tripViewBean;

	@Id
	private int travelId;
	
	@Id
	private int viewid;
	
	@Column(name="tripday")
	private int tripday;
	
	@ManyToOne
	@JoinColumn(name="tripid")
	public TripAllBean getTripAllBean() {
		return tripAllBean;
	}
	
	@ManyToOne
	@JoinColumn(name="viewid")
	public TripViewBean getTripViewBean() {
		return tripViewBean;
	}
	
	public TripListBean() {
		
	}
	public TripListBean(String viewName, Date startTime, Date endTime, String tripType, String tripname, int travelId,
			int tripday, int viewid) {
	
		this.viewName = viewName;
		this.StartTime = startTime;
		this.endTime = endTime;
		this.tripType = tripType;
		this.tripname = tripname;
		this.travelId = travelId;
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
	public int getravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
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
