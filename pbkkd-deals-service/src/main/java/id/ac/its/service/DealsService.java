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
	void createDeals(Integer id, Integer r_id, String code, String name, String desc, Integer type, Double amount,
			Double max_val, Double min_val, Integer total_limit_use, Integer limit_use_per_user,
			Boolean new_cust_only, Boolean active_status, String start, String end);
	void updateDeals(Integer id, Integer r_id, String code, String name, String desc, Integer type, Double amount,
			Double max_val, Double min_val, Integer total_limit_use, Integer limit_use_per_user,
			Boolean new_cust_only, Boolean active_status, String start, String end);
	void deleteDeals(Integer r_id, Integer id);
	
}
