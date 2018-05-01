package travelPlan.travelView.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import _trip.model.MemberBean;
import travelPlan.travelAll.model.TravelAllBean;
import travelPlan.viewSource.model.viewSourceCollection;

//進入點,table=TravelView
@Entity
@Table(name="TravelView")
public class TravelViewBean {
	//pk,流水號,colum=viewid
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="viewid")
	private int viewid;
	
	
	@Column(name="viewImageId")
	private String viewImageId;
	
	@OneToMany(mappedBy="viewImageId",cascade= {CascadeType.REMOVE})
	private Set<viewSourceCollection> ImageIds;
	//關聯MemberBean,memberid
	//name=本Bean memederId,referencedColumnName=MemberBean的屬性,
	@ManyToOne
	@JoinColumn(name="memberId",referencedColumnName="memberId",insertable=true,updatable=false)
	private MemberBean member;

	
	
	@Column(name="viewName")
	private String viewName;
	@Column(name="viewaddr")
	private String viewaddr;
	@Column(name="viewPhone")
	private String viewPhone;
	@Column(name="coordx")
	private String coordx;
	@Column(name="coordy")
	private String coordy;
	@Column(name="Orgclass")
	private String Orgclass;
	@Column(name="Keyword")
	private String Keyword;
	@Column(name="tdate")
	private java.sql.Date tdate;
	@Column(name="viewDetail")
	private String viewDetail;
	
	//將view Id 加入TravelList,tavelId關連到TravelAllBean的PK
	@ManyToMany
	@JoinTable(name="TravelList",joinColumns=@JoinColumn(name="view_Id"),inverseJoinColumns=@JoinColumn(name="travel_Id"))
	private Set<TravelAllBean> travels;
	//將view Id 加入ViewCollection,member_Id關連到MemberBean的PK
	@ManyToMany
	@JoinTable(name="ViewCollection",joinColumns=@JoinColumn(name="view_Id"),inverseJoinColumns=@JoinColumn(name="member_Id"))
	private Set<MemberBean> members;
	
	
	
	public TravelViewBean() {
		
	}
	
//	private Set<TravelAllBean> view;
	public int getViewid() {
		return viewid;
	}
	public void setViewid(int viewid) {
		this.viewid = viewid;
	}
	
	public String getViewImageId() {
		return viewImageId;
	}

	public void setViewImageId(String viewImageId) {
		this.viewImageId = viewImageId;
	}

	

	

	public Set<viewSourceCollection> getImageIds() {
		return ImageIds;
	}

	public void setImageIds(Set<viewSourceCollection> imageIds) {
		ImageIds = imageIds;
	}

	public MemberBean getMemberId() {
		
		return member;
	}
	public void setMemberId(MemberBean member) {
		this.member = member;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public String getViewaddr() {
		return viewaddr;
	}
	public void setViewaddr(String viewaddr) {
		this.viewaddr = viewaddr;
	}
	public String getViewPhone() {
		return viewPhone;
	}
	public void setViewPhone(String viewPhone) {
		this.viewPhone = viewPhone;
	}
	public String getCoordx() {
		return coordx;
	}
	public void setCoordx(String coordx) {
		this.coordx = coordx;
	}
	public String getCoordy() {
		return coordy;
	}
	public void setCoordy(String coordy) {
		this.coordy = coordy;
	}
	public String getOrgclass() {
		return Orgclass;
	}
	public void setOrgclass(String orgclass) {
		Orgclass = orgclass;
	}
	public String getKeyword() {
		return Keyword;
	}
	public void setKeyword(String keyword) {
		Keyword = keyword;
	}
	public java.sql.Date getTdate() {
		return tdate;
	}
	public void setTdate(java.sql.Date tdate) {
		this.tdate = tdate;
	}
	public Set<TravelAllBean> getTravels() {
		return travels;
	}
	public void setTravels(Set<TravelAllBean> travels) {
		this.travels = travels;
	}

	public String getViewDetail() {
		return viewDetail;
	}

	public void setViewDetail(String viewDetail) {
		this.viewDetail = viewDetail;
	}

	public Set<MemberBean> getMembers() {
		return members;
	}

	public void setMembers(Set<MemberBean> members) {
		this.members = members;
	}
	
	
	




	
	
}
