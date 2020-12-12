package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Employee;
import pl.coderslab.entity.User;
import pl.coderslab.repository.EmployeeRepository;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Employee employee, BindingResult bindingResult, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (bindingResult.hasErrors()) {
            return "employee/form";
        } else {
            employee.setUser(user);
            employeeRepository.save(employee);
        }
        return "redirect:/employee/list/"  + user.getId();
    }

    @GetMapping("/list/{id}")
    public String list(@PathVariable Long id, Model model) {
        List<Employee> employees = employeeRepository.findAllByUserId(id);
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("form/{id}")
    @Transactional
    public String form(@PathVariable long id, Model model) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee foundEmployee = employee.orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        model.addAttribute("employee", foundEmployee);
        return "employee/update";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        return "employee/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        employeeRepository.deleteById(id);
        return "redirect:/employee/list";
    }
}
