package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Visit;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findAllByCustomerId(Long id);

    @Query("SElECT v FROM Visit v WHERE v.startDate >= ?1 AND v.endDate <= ?2 AND v.customer.user.id = ?3")
    List<Visit> findAllByDate(LocalDateTime start, LocalDateTime end, Long id);
}
