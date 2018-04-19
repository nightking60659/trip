package tripview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import triplist.model.TripListBean;

@Entity
@Table(name="travelView")
public class TripViewBean {
	@Id
	@Column(name="viewid")
	private int viewid;
	@Column(name="imageSource")
	private String imageSource;
	@Column(name="memberid")
	private int memberid;
	@Column(name="viewName")
	private String viewName;
	@Column(name="viewQuery")
	private String viewQuery;
	@Column(name="viewPicQuery")
	private String viewPicQuery;
	@Column(name="viewadr")
	private String viewadr;
	@Column(name="viewWeb")
	private String viewWeb;
	@Column(name="viewPhone")
	private String viewPhone;
	@Column(name="viewOpenTime")
	private String viewOpenTime;
	@Column(name="coordx")
	private String coordx;
	@Column(name="coordy")
	private String coordy;
	@Column(name="tdate")
	private java.sql.Date tdate;
	
	private TripViewBean view;
	
	@OneToMany(targetEntity=TripListBean.class, mappedBy="TripViewBean", fetch=FetchType.EAGER)
	public TripViewBean getView() {
		return view;
	}
	
	public void setView(TripViewBean view) {
		this.view = view;
	}
	
	
	
	





	public int getViewid() {
		return viewid;
	}
	public void setViewid(int viewid) {
		this.viewid = viewid;
	}
	public String getImageSource() {
		return imageSource;
	}
	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getViewname() {
		return viewName;
	}
	public void setViewname(String viewname) {
		viewName = viewname;
	}
	public String getViewQuery() {
		return viewQuery;
	}
	public void setViewQuery(String viewQuery) {
		this.viewQuery = viewQuery;
	}
	public String getViewPicQuery() {
		return viewPicQuery;
	}
	public void setViewPicQuery(String viewPicQuery) {
		this.viewPicQuery = viewPicQuery;
	}
	public String getViewadr() {
		return viewadr;
	}
	public void setViewadr(String viewadr) {
		this.viewadr = viewadr;
	}
	public String getViewWeb() {
		return viewWeb;
	}
	public void setViewWeb(String viewWeb) {
		this.viewWeb = viewWeb;
	}
	public String getViewPhone() {
		return viewPhone;
	}
	public void setViewPhone(String viewPhone) {
		this.viewPhone = viewPhone;
	}
	public String getViewOpenTime() {
		return viewOpenTime;
	}
	public void setViewOpenTime(String viewOpenTime) {
		this.viewOpenTime = viewOpenTime;
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
	public java.sql.Date getTdate() {
		return tdate;
	}
	public void setTdate(java.sql.Date tdate) {
		this.tdate = tdate;
	}
	
}
