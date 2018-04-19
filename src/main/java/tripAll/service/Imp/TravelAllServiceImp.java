package tripAll.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripAll.Dao.Imp.TripAllDaoSpring;
import tripAll.model.TripAllBean;
import tripAll.service.TripAllService;
@Service
public class TravelAllServiceImp implements TripAllService {
	
	@Autowired
	private TripAllDaoSpring tripAllDaoSpring;
	
	@Override
	public void addTravel(TripAllBean bean) {
		
		tripAllDaoSpring.insert(bean);
	}

}
