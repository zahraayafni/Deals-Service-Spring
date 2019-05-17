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
	
	@Query("SELECT d FROM deals d WHERE to_timestamp(cast(d.end_time as text), 'yyyy-MM-dd HH24:mi:ss') >= to_timestamp(cast(?1 as text), 'yyyy-MM-dd HH24:mi:ss') AND d.active_status = true")
	List<Deals> findAllActiveDeals(Date now);
	
	@Query("SELECT d FROM deals d WHERE to_timestamp(cast(d.end_time as text), 'yyyy-MM-dd HH24:mi:ss') < to_timestamp(cast(?1 as text), 'yyyy-MM-dd HH24:mi:ss') OR d.active_status = false")
	List<Deals> findAllExpDeals(Date now);
	
	@Query("SELECT d FROM deals d WHERE  d.r_id = ?1")
	List<Deals> findAllDealsByRestaurant(Integer r_id);
	
	@Query("SELECT d FROM deals d WHERE  d.r_id = ?1 AND to_timestamp(cast(d.end_time as text), 'yyyy-MM-dd HH24:mi:ss') >= to_timestamp(cast(?2 as text), 'yyyy-MM-dd HH24:mi:ss') AND d.active_status = true")
	List<Deals> findAllActiveDealsByRestaurant(Integer r_id, Date now);
	
	@Query("SELECT d FROM deals d WHERE d.r_id = ?1 AND (to_timestamp(cast(d.end_time as text), 'yyyy-MM-dd HH24:mi:ss') < to_timestamp(cast(?2 as text), 'yyyy-MM-dd HH24:mi:ss') OR d.active_status = false)") // KUrang cek tanggal dan active status
	List<Deals> findAllExpDealsByRestaurant(Integer r_id, Date now);
	
	@Query("SELECT d FROM deals d WHERE d.r_id = ?1 AND d.id = ?2")
	Deals findADealsByRestaurant(Integer r_id, Integer id);
	
	@Query("SELECT d FROM deals d WHERE d.r_id = ?1 AND d.code = ?2")
	Deals findADealsRestaurantByCode(Integer r_id, String code);
}
