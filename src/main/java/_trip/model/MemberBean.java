package _trip.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import travelPlan.travelAll.model.TravelAllBean;
import travelPlan.travelView.model.TravelViewBean;

@Entity
@Table(name="TravelMember")
public class MemberBean {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
@Column(name="memberId")
private int mid;

@Column(name="password")
private String password;


@OneToMany(mappedBy="memberId",cascade= {CascadeType.REMOVE})
private Set<TravelViewBean> ViewMB;

@OneToMany(mappedBy="memberId",cascade= {CascadeType.REMOVE})
private Set<TravelViewBean> travelMB;

@ManyToMany
@JoinTable(name="travelCollection",joinColumns=@JoinColumn(name="member_Id"),inverseJoinColumns=@JoinColumn(name="travel_Id"))
private Set<TravelAllBean> travels;

@ManyToMany
@JoinTable(name="viewcollection",joinColumns=@JoinColumn(name="member_Id"),inverseJoinColumns=@JoinColumn(name="view_Id"))
private Set<TravelViewBean> views;

public int getMid() {
	return mid;
}

public void setMid(int mid) {
	this.mid = mid;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Set<TravelViewBean> getViewMB() {
	return ViewMB;
}

public void setViewMB(Set<TravelViewBean> viewMB) {
	ViewMB = viewMB;
}

public Set<TravelViewBean> getTravelMB() {
	return travelMB;
}

public void setTravelMB(Set<TravelViewBean> travelMB) {
	this.travelMB = travelMB;
}

public Set<TravelAllBean> getTravels() {
	return travels;
}

public void setTravels(Set<TravelAllBean> travels) {
	this.travels = travels;
}

public Set<TravelViewBean> getViews() {
	return views;
}

public void setViews(Set<TravelViewBean> views) {
	this.views = views;
}







}
