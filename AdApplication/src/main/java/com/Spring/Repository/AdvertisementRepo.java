package com.Spring.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.Spring.Entity.Advertises;

@Component
public interface AdvertisementRepo extends JpaRepository<Advertises, Long> {
	List<Advertises> findByOrderName(String title);
}