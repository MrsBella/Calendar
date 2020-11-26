package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Customer;
import pl.coderslab.entity.CustomerTreatment;
import pl.coderslab.entity.Treatment;
import pl.coderslab.repository.CustomerRepository;
import pl.coderslab.repository.CustomerTreatmentRepository;
import pl.coderslab.repository.TreatmentRepository;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/findById")
    public String findTreatmentsByCustomerId() {

        List<CustomerTreatment> customerTreatments = customerTreatmentRepository.findAllByCustomerId(1L);

        System.out.println(customerTreatments.size());

        return "user/hello";
    }
}
