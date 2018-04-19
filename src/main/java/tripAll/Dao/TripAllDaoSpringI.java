package tripAll.Dao;

import java.sql.SQLException;
import java.util.List;

import tripAll.model.TripAllBean;

public interface TripAllDaoSpringI {

	TripAllBean Select_Tripid(TripAllBean bean);

	List<TripAllBean> selectAllTrip();

	String insert = "insert into tripALL (tripid ,tripName, StartDate, endDate, tripDays) values (?,?,?,?,?)";

	void insert(TripAllBean bean);

	void updateTrip(TripAllBean bean) throws SQLException;

	void delete(TripAllBean bean);

}