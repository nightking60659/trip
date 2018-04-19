package tripAll.Dao.Imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tripAll.Dao.TripAllDaoSpringI;
import tripAll.model.TripAllBean;


public class TripAllDaoSpring implements TripAllDaoSpringI {

	@Autowired
	SessionFactory factory;

	@Override
	public TripAllBean Select_Tripid(TripAllBean bean) {
		TripAllBean tao=null;
		Session session = factory.getCurrentSession();
		tao=session.get(TripAllBean.class, bean.getTripid());
		
		return tao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TripAllBean> selectAllTrip() {
		String hql = "FROM TripAllBean";
		List<TripAllBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void insert(TripAllBean bean) {
		Session session = factory.getCurrentSession();
		session.save(bean);
				
	}

	@Override
	public void updateTrip(TripAllBean bean) throws SQLException {
		String hql = "update TripAllBean SET tripName=:tripName ,startDate=:startDate ,endDate:endDate Where tripid=:tripid";
		Session session= factory.getCurrentSession();
		session.createQuery(hql).setParameter("tripName", bean.getTripName()).setParameter("startDate", bean.getStartDate()).setParameter("endDate", bean.getEndDate()).setParameter("tripDays", bean.getTripDays()).executeUpdate();
	}

	@Override
	public void delete(TripAllBean bean) {
		Session session= factory.getCurrentSession();
		session.delete(bean.getTripid());
		
	}

	

	
	
}
