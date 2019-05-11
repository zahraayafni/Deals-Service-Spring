package id.ac.its.service;

import java.util.List;

import id.ac.its.model.DealsHistory;

public interface DealsHistoryService {
	List<DealsHistory> getAllUserHistory(Integer u_id);
	public void checkDeals(Integer u_id, Integer r_id, Integer id);
	public void useDeals(Integer u_id, Integer r_id, Integer id);
}
