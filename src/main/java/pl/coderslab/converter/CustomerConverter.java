package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Customer;
import pl.coderslab.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;

public class CustomerConverter implements Converter<String, Customer> {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer convert(String s) {
        long id = Long.parseLong(s);
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found." +
                "Id: " + s));
    }
}
