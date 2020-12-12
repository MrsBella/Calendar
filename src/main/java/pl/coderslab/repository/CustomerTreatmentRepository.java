package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.CustomerTreatment;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerTreatmentRepository extends JpaRepository<CustomerTreatment, Long> {

    List<CustomerTreatment> findAllByCustomerId(Long id);

    @Query("SElECT ct FROM CustomerTreatment ct WHERE ct.localDateTime >= ?1 AND ct.localDateTime <= ?2")
    List<CustomerTreatment> findAllByDate(LocalDateTime start, LocalDateTime end);

//    @Query("SELECT COUNT(ct) FROM CustomerTreatment ct")
//    int cou
}

