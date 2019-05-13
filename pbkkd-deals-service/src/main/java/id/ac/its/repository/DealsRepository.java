package id.ac.its.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.ac.its.model.Deals;

@Repository
public interface DealsRepository extends JpaRepository<Deals, Integer> {

}
