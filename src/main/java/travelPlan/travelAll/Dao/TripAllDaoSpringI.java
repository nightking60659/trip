package travelPlan.travelAll.Dao;

import java.sql.SQLException;
import java.util.List;

import travelPlan.travelAll.model.TravelAllBean;

public interface TripAllDaoSpringI {

	TravelAllBean Select_Tripid(TravelAllBean bean);

	List<TravelAllBean> selectAllTrip();

	String insert = "insert into tripALL (tripid ,tripName, StartDate, endDate, tripDays) values (?,?,?,?,?)";

	void insert(TravelAllBean bean);

	void updateTrip(TravelAllBean bean) throws SQLException;

	void delete(TravelAllBean bean);

}