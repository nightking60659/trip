package _trip.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import _trip.model.TripBean;

public interface TripDAOI {

	TripBean select(String viewid);

	LinkedList<HashMap<String, String>> select();

	TripBean insertTrip(TripBean bean) throws SQLException;

	TripBean updateTrip(TripBean bean) throws SQLException;

	int delete(String viewid);

}