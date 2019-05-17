package id.ac.its.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.ac.its.model.DealsHistory;

@Repository
public interface DealsHistoryRepository extends JpaRepository<DealsHistory, Integer> {
	
	@Query("SELECT d FROM deals_history d WHERE d.u_id = ?1")
	List<DealsHistory> findAUserHistory(Integer u_id);
	
	@Query("SELECT d FROM deals_history d WHERE d.r_id = ?1")
	List<DealsHistory> findARestaurantHistory(Integer r_id);
	
	@Query("SELECT d FROM deals_history d WHERE d.u_id = ?1 AND d.r_id = ?2 AND d.id = ?3")
	List<DealsHistory> findSpecificDealsHistory(Integer u_id, Integer r_id, Integer id);
}
