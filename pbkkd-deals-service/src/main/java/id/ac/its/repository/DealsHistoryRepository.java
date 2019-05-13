package id.ac.its.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import id.ac.its.model.DealsHistory;

@Repository
public interface DealsHistoryRepository extends JpaRepository<DealsHistory, Integer> {

}
