package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Customer;
import pl.coderslab.entity.CustomerProduct;
import pl.coderslab.entity.Product;
import pl.coderslab.repository.CustomerProductRepository;
import pl.coderslab.repository.CustomerRepository;
import pl.coderslab.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/customerProduct")
@Transactional
public class CustomerProductController {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CustomerProductRepository customerProductRepository;


    public CustomerProductController(CustomerRepository customerRepository, ProductRepository productRepository,
                                     CustomerProductRepository customerProductRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.customerProductRepository = customerProductRepository;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("customerProduct", new CustomerProduct());

        Customer customer = customerRepository.getOne(1L);
        Product product = productRepository.getOne(1L);
        LocalDateTime localDateTime = LocalDateTime.now();

        CustomerProduct customerProduct = new CustomerProduct(customer, product, localDateTime);
        customerProductRepository.save(customerProduct);
        return "user/hello";
    }

    @GetMapping("/findById/{id}")
    public String findProductsByCustomerId(@PathVariable long id, Model model) {

        List<CustomerProduct> customerProducts = customerProductRepository.findAllByCustomerId(id);
        System.out.println(customerProducts.size());

        return "user/hello";
    }
}
