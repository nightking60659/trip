package travelPlan.travelList.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TravelListPK implements Serializable {

	private int viewid;
	
	private int travelId;

	public TravelListPK() {
	
	}
	
	

	public TravelListPK(int viewid, int travelId) {
		this.viewid = viewid;
		this.travelId = travelId;
	}



	public int getViewid() {
		return viewid;
	}

	public void setViewid(int viewid) {
		this.viewid = viewid;
	}

	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	
	
}
