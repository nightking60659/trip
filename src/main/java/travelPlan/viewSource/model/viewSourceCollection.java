package travelPlan.viewSource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import travelPlan.travelView.model.TravelViewBean;

@Entity
@Table(name="ViewSource")
public class viewSourceCollection {
	
	//關聯TravelViewBean的viewImageId
	@ManyToOne
	@JoinColumn(name="viewImageId",referencedColumnName="viewImageId",insertable=false,updatable=false)
	private TravelViewBean viewImageId;
	
	@Id
	@Column(name="ImgSrc")
	private String ImgSrc;

	public TravelViewBean getViewImageId() {
		return viewImageId;
	}

	public void setViewImageId(TravelViewBean viewImageId) {
		this.viewImageId = viewImageId;
	}

	public String getImgSrc() {
		return ImgSrc;
	}

	public void setImgSrc(String imgSrc) {
		ImgSrc = imgSrc;
	}
	
	
}
