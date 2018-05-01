package _trip.DAO;

import java.sql.SQLException;

import tripAll.model.TripAllBean;

public interface TripDaoInterface {

	TravelAllBean Select_Tripid(TravelAllBean bean);

	TravelAllBean selectAllTrip();

	TravelAllBean insert(TravelAllBean bean);

	TravelAllBean updateTrip(TravelAllBean bean) throws SQLException;

	int delete(TravelAllBean bean);

}