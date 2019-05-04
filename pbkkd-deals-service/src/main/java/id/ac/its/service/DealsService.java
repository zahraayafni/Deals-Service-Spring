package id.ac.its.service;

import java.util.Date;
import java.util.List;
import id.ac.its.model.Deals;

public interface DealsService {

	List<Deals> getAllDeals();
	List<Deals> getActiveDeals();
	List<Deals> getExpDeals();
	Deals getDeals(Integer d_id);
	void createDeals(Integer d_id, String d_code, String d_name, String d_desc, Integer d_type, Double d_amount, Integer d_max_val,
			Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust, Boolean d_new_cust_only, Date d_start,
			Date d_end);
	void updateDeals(Integer d_id, String d_code, String d_name, String d_desc, Integer d_type, Double d_amount, Integer d_max_val,
			Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust, Boolean d_new_cust_only, Date d_start,
			Date d_end);
	void deleteDeals(Integer d_id);
	
}
