package travelPlan.travelAll.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travelPlan.travelAll.Dao.Imp.TravelAllDaoSpring;
import travelPlan.travelAll.model.TravelAllBean;
import travelPlan.travelAll.service.TravelAllService;
@Service
public class TravelAllServiceImp implements TravelAllService {
	
	@Autowired
	private TravelAllDaoSpring tripAllDaoSpring;
	
	@Override
	public void addTravel(TravelAllBean bean) {
		
		tripAllDaoSpring.insert(bean);
	}
	
	
	

}
