package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.CustomerTreatment;

public interface CustomerTreatmentRepository extends JpaRepository<CustomerTreatment, Long> {
}
