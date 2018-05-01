package travelPlan.travelView.Dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _trip.model.MemberBean;
import travelPlan.travelView.Dao.TripViewInterface;
import travelPlan.travelView.exception.ViewNotFoundException;
import travelPlan.travelView.model.TravelViewBean;
@Repository
public class TravelViewDaoImp implements TripViewInterface {
	@Autowired
	SessionFactory factory;

	@Override
	public List<TravelViewBean> select() {
		String hql = "From TravelViewBean";
		Session session = factory.getCurrentSession();
		List<TravelViewBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		
		return list;
	}

	@Override
	public TravelViewBean select_ViewId(int viewId) {
		TravelViewBean bean = null;
		Session session = factory.getCurrentSession();
		bean = session.get(TravelViewBean.class, viewId);
		if(bean == null) throw new ViewNotFoundException(viewId);
		return bean;
	}


	@Override
	public void insert(TravelViewBean bean) {
		Session session  =factory.getCurrentSession();
//		MemberBean mb = getMemberId(bean.getMemberId());
		
		session.save(bean);
		
	}
	
	public MemberBean getMemberId(int memberId) {
		Session session= factory.getCurrentSession();
		MemberBean id = session.get(MemberBean.class, memberId);
		return id;
		
	}

	@Override
	public void update(TravelViewBean bean) {
		Session session= factory.getCurrentSession();
		session.saveOrUpdate(bean);
		
		
	}

	@Override
	public void delete(int viewId) {
		Session session= factory.getCurrentSession();
		session.delete(viewId);
	}
	
	

}
