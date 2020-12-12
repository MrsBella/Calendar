package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.CustomerTreatment;
import pl.coderslab.entity.Visit;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query("SElECT v FROM Visit v WHERE v.startDate >= ?1 AND v.endDate <= ?2")
    List<Visit> findAllByDate(LocalDateTime start, LocalDateTime end);
}
