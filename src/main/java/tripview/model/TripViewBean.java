package tripview.model;

public class TripViewBean {
	private int viewid;
	private String imageSource;
	private int memberid;
	private String Viewname;
	private String viewQuery;
	private String viewPicQuery;
	private String viewadr;
	private String viewWeb;
	private String viewPhone;
	private String viewOpenTime;
	private String coordx;
	private String coordy;
	private java.sql.Date tdate;
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
		return Viewname;
	}
	public void setViewname(String viewname) {
		Viewname = viewname;
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
