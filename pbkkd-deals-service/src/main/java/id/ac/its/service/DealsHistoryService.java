package id.ac.its.service;

import java.util.List;

import id.ac.its.model.DealsHistory;

public interface DealsHistoryService {
	List<DealsHistory> getUserHistory(Integer u_id);
	List<DealsHistory> getRestaurantHistory(Integer r_id);
	public Double checkDeals(Integer u_id, Integer r_id, String code, Double total_amount );
	public DealsHistory useDeals(DealsHistory dealsHistory, Integer u_id);
}
