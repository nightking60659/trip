package travelPlan.travelAll.Dao.Imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import travelPlan.travelAll.Dao.TripAllDaoSpringI;
import travelPlan.travelAll.model.TravelAllBean;


public class TravelAllDaoSpring implements TripAllDaoSpringI {

	@Autowired
	SessionFactory factory;

	@Override
	public TravelAllBean Select_Tripid(TravelAllBean bean) {
		TravelAllBean tao=null;
		Session session = factory.getCurrentSession();
		tao=session.get(TravelAllBean.class, bean.getTravelId());
		
		return tao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TravelAllBean> selectAllTrip() {
		String hql = "FROM TripAllBean";
		List<TravelAllBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void insert(TravelAllBean bean) {
		Session session = factory.getCurrentSession();
		session.save(bean);
				
	}

	@Override
	public void updateTrip(TravelAllBean bean) throws SQLException {
		String hql = "update TripAllBean SET tripName=:tripName ,startDate=:startDate ,endDate:endDate Where tripid=:tripid";
		Session session= factory.getCurrentSession();
		session.createQuery(hql).setParameter("tripName", bean.getTripName()).setParameter("startDate", bean.getStartDate()).setParameter("endDate", bean.getEndDate()).setParameter("tripDays", bean.getTripDays()).executeUpdate();
	}

	@Override
	public void delete(TravelAllBean bean) {
		Session session= factory.getCurrentSession();
		session.delete(bean.getTravelId());
		
	}

	

	
	
}
