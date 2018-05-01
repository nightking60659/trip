package travelPlan.travelList.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import travelPlan.travelAll.model.TravelAllBean;
import travelPlan.travelView.model.TravelViewBean;

@Entity
@Table(name="TravelList")
@IdClass(TravelListPK.class)
public class TravelListBean {
	
	@Column(name="viewName")
	private String viewName;
	@Column(name="StartTime")
	private java.sql.Date  StartTime;
	@Column(name="endTime")
	private java.sql.Date  endTime;
	@Column(name="tripType")
	private String travelType;
	@Column(name="tripname")
	private String travelName;
	

	@Id
	@Column(name="travelId")
	private int travelId;
	
	@Id
	@Column(name="viewid")
	private int viewid;
	
	@Column(name="tripday")
	private int tripday;
	
	
	
	
	public TravelListBean() {
		
	}
	public TravelListBean(String viewName, Date startTime, Date endTime, String tripType, String tripname, int travelId,
			int tripday, int viewid) {
	
		this.viewName = viewName;
		this.StartTime = startTime;
		this.endTime = endTime;
		this.travelType = tripType;
		this.travelName = tripname;
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
	public String getTravelType() {
		return travelType;
	}
	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}
	public String getTravelName() {
		return travelName;
	}
	public void setTravelName(String travelName) {
		this.travelName = travelName;
	}

	public int getTravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	public int getViewid() {
		return viewid;
	}
	public void setViewid(int viewid) {
		this.viewid = viewid;
	}
	public int getTripday() {
		return tripday;
	}
	public void setTripday(int tripday) {
		this.tripday = tripday;
	}


	

}
