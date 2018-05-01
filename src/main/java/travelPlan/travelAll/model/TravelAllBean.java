package travelPlan.travelAll.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import _trip.model.MemberBean;
import travelPlan.travelView.model.TravelViewBean;

@Entity
@Table(name="TravelPlan")
public class TravelAllBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
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
	
	//memberId關連到MemeberBean的memberId
	@ManyToOne
	@JoinColumn(name="memberId",referencedColumnName="memberId",insertable=true,updatable=false)
	private MemberBean memberId;//fk
	

	
	//將travel_Id加入TravelList,view_Id關連到TravelViewBean的PK
	@ManyToMany
	@JoinTable(name="TravelList",joinColumns=@JoinColumn(name="travel_Id"),inverseJoinColumns=@JoinColumn(name="view_Id"))
	private Set<TravelViewBean> Views;
	//將travel_Id加入travelCollection,member_Id關連到MemberBean的PK
	@ManyToMany
	@JoinTable(name="travelCollection",joinColumns=@JoinColumn(name="travel_Id"),inverseJoinColumns=@JoinColumn(name="member_Id"))
	private Set<MemberBean> travels;
	
	
	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	public String getTravelName() {
		return travelName;
	}

	public void setTravelName(String travelName) {
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

	public int getTravelDays() {
		return travelDays;
	}

	public void setTravelDays(int travelDays) {
		this.travelDays = travelDays;
	}

	
	public MemberBean getMemberId() {
		return memberId;
	}

	public void setMemberId(MemberBean memberId) {
		this.memberId = memberId;
	}

	public Set<TravelViewBean> getViews() {
		return Views;
	}

	public void setViews(Set<TravelViewBean> views) {
		Views = views;
	}

	

	
//	@ManyToMany
//	@JoinTable(name="TripListBean",joinColumns=@JoinColumn(name="traveId"),
//	inverseJoinColumns=@JoinColumn(name="viewid"))
//	private Set<TravelViewBean> tripList;
//	
//	
//	public void setTravel(Set<TravelViewBean> travel) {
//		this.travel = travel;
//	}
//	
	
	
	
	

	
}
