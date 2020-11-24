package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Employee;
import pl.coderslab.repository.EmployeeRepository;

import javax.persistence.EntityNotFoundException;

public class EmployeeConverter implements Converter<String, Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee convert(String s) {
        long id = Long.parseLong(s);
        return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found." +
        "Id: " + s));
    }
}
