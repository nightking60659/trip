package tripAll.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import tripview.model.TripViewBean;

@Entity
@Table(name="TravelPlan")
public class TripAllBean {

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column
	private int travelId;//pk
	@Column(name="travelName")
	private String travelName;
	@Column(name="startDate")
	private java.sql.Date startDate;
	@Column(name="endDate")
	private java.sql.Date endDate;
	@Column(name="travel_Days")
	private int travelDays;
	@Column(name="memberId")
	private int memberid;//fk
	

	public TripAllBean(String travelName ,java.sql.Date StartDate ,java.sql.Date endDate, int travelDays) {
		
		this.travelName = travelName;
		this.startDate = StartDate;
		this.endDate = endDate;
		this.travelDays = travelDays;
	}
	
	private Set<TripViewBean> travel;
	
	public Set<TripViewBean> getTravel() {
		return travel;
	}
	
	
	@ManyToMany
	@JoinTable(name="TripListBean",joinColumns=@JoinColumn(name="traveId"),
	inverseJoinColumns=@JoinColumn(name="viewid"))
	private Set<TripViewBean> tripList;
	
	
	public void setTravel(Set<TripViewBean> travel) {
		this.travel = travel;
	}
	
	
	
	
	

	public int getMemberid() {
		return memberid;
	}
	
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public TripAllBean() {
		
	}
	@Id
	public int getTravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	public String getTripName() {
		return travelName;
	}
	public void setTripName(String travelName) {
		this.travelName = travelName;
	}
	public java.sql.Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.sql.Date startDate) {
			this.startDate = startDate;
	}
	public java.sql.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}
	public int getTripDays() {
		return travelDays;
	}
	public void setTripDays(int travelDays) {
		this.travelDays = travelDays;
	}
	
}
