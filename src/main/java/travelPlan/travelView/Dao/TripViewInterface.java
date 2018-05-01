package travelPlan.travelView.Dao;

import java.util.List;

import travelPlan.travelView.model.TravelViewBean;

public interface TripViewInterface {


	TravelViewBean select_ViewId(int viewId);


	List<TravelViewBean> select();


	public void insert(TravelViewBean bean);


	public void update(TravelViewBean bean);


	public void delete(int viewId);

}