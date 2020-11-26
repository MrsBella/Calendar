package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.CustomerTreatment;

import java.util.List;

public interface CustomerTreatmentRepository extends JpaRepository<CustomerTreatment, Long> {

    List<CustomerTreatment> findAllByCustomerId(Long id);
}

