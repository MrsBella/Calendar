package pl.coderslab.controller;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Customer;
import pl.coderslab.entity.CustomerTreatment;
import pl.coderslab.entity.Treatment;
import pl.coderslab.repository.CustomerRepository;
import pl.coderslab.repository.CustomerTreatmentRepository;
import pl.coderslab.repository.TreatmentRepository;

import javax.persistence.EntityNotFoundException;
import javax.persistence.FetchType;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customerTreatment")
@Transactional
public class CustomerTreatmentController {

    private final CustomerRepository customerRepository;
    private final TreatmentRepository treatmentRepository;
    private final CustomerTreatmentRepository customerTreatmentRepository;

    public CustomerTreatmentController(CustomerRepository customerRepository, TreatmentRepository treatmentRepository,
                                       CustomerTreatmentRepository customerTreatmentRepository) {
        this.customerRepository = customerRepository;
        this.treatmentRepository = treatmentRepository;
        this.customerTreatmentRepository = customerTreatmentRepository;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("customerTreatment", new CustomerTreatment());

        Customer customer = customerRepository.getOne(2L);
        Treatment treatment = treatmentRepository.getOne(4L);
        LocalDateTime localDateTime = LocalDateTime.now();

        CustomerTreatment customerTreatment = new CustomerTreatment(customer, treatment, localDateTime);
        customerTreatmentRepository.save(customerTreatment);
        return "user/hello";
    }

    @GetMapping("/findById/{id}")
    @Transactional
    public String findTreatmentsByCustomerId(@PathVariable long id, Model model) {
        Customer customer = customerRepository.getOne(id);
        model.addAttribute("customer", customer);

        List<CustomerTreatment> customerTreatments = customerTreatmentRepository.findAllByCustomerId(id);

        Hibernate.initialize(customer.getCustomerTreatments());

        if (customerTreatments.size() != 0) {
            model.addAttribute("customerTreatments", customerTreatments);
        } else {
            model.addAttribute("customerTreatments", null);
        }
        return "customer/history";
    }
}
