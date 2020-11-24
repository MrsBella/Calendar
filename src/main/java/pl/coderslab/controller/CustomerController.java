package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Customer;
import pl.coderslab.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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

    @GetMapping("/list")
    public String list(Model model) {
        List<Customer> customers = customerRepository.findAll();
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
}
