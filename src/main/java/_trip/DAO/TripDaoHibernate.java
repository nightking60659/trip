package _trip.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import org.hibernate.Session;

import _trip.model.TripBean;

public class TripDaoHibernate implements TripDAOI {
	private Session session ;
	TripDaoHibernate(Session session){
		this.session=session;
	}
	public Session getSession() {
		return session;
	}
	

	public TripBean select(String viewid) {
		return this.getSession().get(TripBean.class, viewid);
		
		
		
		
		
		
	}

	@Override
	public LinkedList<HashMap<String, String>> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TripBean insertTrip(TripBean bean) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TripBean updateTrip(TripBean bean) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String viewid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
