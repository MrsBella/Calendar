package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.CustomerProduct;

import java.util.List;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long> {

    List<CustomerProduct> findAllByCustomerId(Long id);
}
