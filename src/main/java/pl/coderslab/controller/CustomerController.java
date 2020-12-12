package pl.coderslab.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Customer;
import pl.coderslab.entity.CustomerProduct;
import pl.coderslab.entity.Visit;
import pl.coderslab.repository.CustomerProductRepository;
import pl.coderslab.repository.CustomerRepository;
import pl.coderslab.repository.VisitRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerProductRepository customerProductRepository;
    private final VisitRepository visitRepository;

    public CustomerController(CustomerRepository customerRepository, CustomerProductRepository customerProductRepository, VisitRepository visitRepository) {
        this.customerRepository = customerRepository;
        this.customerProductRepository = customerProductRepository;
        this.visitRepository = visitRepository;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/form";
        } else {
            customerRepository.save(customer);
        }
        return "redirect:/customer/list";
    }

    @GetMapping("/list/{id}")
    public String list(@PathVariable Long id, Model model) {
        List<Customer> customers = customerRepository.findAllByUserId(id);
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("form/{id}")
    @Transactional
    public String form(@PathVariable long id, Model model) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer foundCustomer = customer.orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        model.addAttribute("customer", foundCustomer);
        return "customer/update";
    }

    @GetMapping("/findById/{id}")
    @Transactional
    public String findTreatmentsAndProductsByCustomerId(@PathVariable long id, Model model) {
        Customer customer = customerRepository.getOne(id);
        model.addAttribute("customer", customer);

        List<Visit> visits = visitRepository.findAllByCustomerId(id);
        List<CustomerProduct> customerProducts = customerProductRepository.findAllByCustomerId(id);

        Hibernate.initialize(customer.getCustomerProducts());

        if (visits.size() != 0) {
            model.addAttribute("visits", visits);
        } else {
            model.addAttribute("visits", null);
        }

        if (customerProducts.size() != 0) {
            model.addAttribute("customerProducts", customerProducts);
        } else {
            model.addAttribute("customerProducts", null);
        }

        return "customer/history";
    }
}
