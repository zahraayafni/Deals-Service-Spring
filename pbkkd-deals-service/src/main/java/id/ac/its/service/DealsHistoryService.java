package id.ac.its.service;

import java.util.List;

import id.ac.its.model.DealsHistory;

public interface DealsHistoryService {
	List<DealsHistory> getUserHistory(Integer u_id);
	public Double checkDeals(Integer u_id, Integer r_id, Integer id, Double total_amount );
	public void useDeals(Integer u_id, Integer r_id, Integer id);
}
