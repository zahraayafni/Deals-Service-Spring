package id.ac.its.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import id.ac.its.model.Deals;

@Repository
public interface DealsRepository extends JpaRepository<Deals, Integer> {
	
	@Query("SELECT d FROM deals d WHERE d.end >= ?1 AND d.active_status = 1")
	List<Deals> findAllActiveDeals(Date now);
	
	@Query("SELECT d FROM deals d WHERE d.end < ?1 OR d.active_status = 0")
	List<Deals> findAllExpDeals(Date now);
	
	@Query("SELECT d FROM deals d WHERE  d.r_id = ?1")
	List<Deals> findAllDealsByRestaurant(Integer r_id);
	
	@Query("SELECT d FROM deals d WHERE  d.r_id = ?1 AND d.end > ?2 AND d.active_status = 1")
	List<Deals> findAllActiveDealsByRestaurant(Integer r_id, Date now);
	
	@Query("SELECT d FROM deals d WHERE d.r_id = ?1 AND (d.end < ?2 OR d.active_status = 0)") // KUrang cek tanggal dan active status
	List<Deals> findAllExpDealsByRestaurant(Integer r_id, Date now);
	
	@Query("SELECT d FROM deals d WHERE d.r_id = ?1 AND d.id = ?2")
	Deals findADealsByRestaurant(Integer r_id, Integer id);
}
