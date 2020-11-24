package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
