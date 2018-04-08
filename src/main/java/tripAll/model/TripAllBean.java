package tripAll.model;

public class TripAllBean {

	private int tripid;
	private String tripName;
	private java.sql.Date StartDate;
	private java.sql.Date endDate;
	private int tripDays;
	
	public TripAllBean(String tripName ,java.sql.Date StartDate ,java.sql.Date endDate, int tripDays) {
		
		this.tripName = tripName;
		this.StartDate = StartDate;
		this.endDate = endDate;
		this.tripDays = tripDays;
	}
	
	public TripAllBean() {
		
	}

	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public java.sql.Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(java.sql.Date startDate) {
		StartDate = startDate;
	}
	public java.sql.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}
	public int getTripDays() {
		return tripDays;
	}
	public void setTripDays(int tripDays) {
		this.tripDays = tripDays;
	}
	
}
