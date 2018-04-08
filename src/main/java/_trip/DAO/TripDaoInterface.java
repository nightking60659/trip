package _trip.DAO;

import java.sql.SQLException;

import tripAll.model.TripAllBean;

public interface TripDaoInterface {

	TripAllBean Select_Tripid(TripAllBean bean);

	TripAllBean select();

	TripAllBean insert(TripAllBean bean);

	TripAllBean updateTrip(TripAllBean bean) throws SQLException;

	int delete(TripAllBean bean);

}