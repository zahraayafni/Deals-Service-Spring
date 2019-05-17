package id.ac.its.service;

import java.util.List;
import id.ac.its.model.Deals;

public interface DealsService {

	List<Deals> getAllDeals();
	List<Deals> getActiveDeals();
	List<Deals> getExpDeals();
	List<Deals> getAllDealsByRestaurant(Integer r_id);
	List<Deals> getActiveDealsByRestaurant(Integer r_id);
	List<Deals> getExpDealsByRestaurant(Integer r_id);
	Deals getDeals(Integer r_id, Integer id);
	Deals getDealsByCode(Integer r_id, String code);
	Deals createDeals(Deals deals, Integer r_id);
	Deals updateDeals(Deals deals, Integer r_id, Integer id);
	Deals deleteDeals(Integer r_id, Integer id);
	
}
