package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Customer;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CustomerRepository;
import pl.coderslab.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("user")
@RequestMapping("/user")
@Transactional
public class UserController {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @ModelAttribute("customers")
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid User user, BindingResult bindingResult, Model model) {
        if ((userRepository.findByEmail(user.getEmail())) == null && !(user.getEmail().equals(""))) {
            if (bindingResult.hasErrors()) {
                return "user/form";
            } else {
                if (user.getPassword().equals(user.getRepeatPassword()) && !(user.getPassword().equals(""))) {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    userRepository.save(user);
                } else {
                    model.addAttribute("msg2", "Passwords do not match!");
                    return "user/form";
                }
            }
        } else {
            model.addAttribute("msg", "Email already exist or no email!");
            return "user/form";
        }
        return "redirect:/user/home";
    }

    @GetMapping("/form/{id}")
    @Transactional
    public String form(@PathVariable long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        User foundUser = user.orElseThrow(() -> new EntityNotFoundException("User not found"));
        model.addAttribute("user", foundUser);
        return "user/update";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/login")
    public String processLogin(User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        } else {

            if ((userRepository.findByEmail(user.getEmail()) == null) || !(BCrypt.checkpw(user.getPassword(),
                    (userRepository.findByEmail(user.getEmail()).getPassword())))) {
                model.addAttribute("msg", "Bad email or password.");
                return "user/login";
            } else {
                user = userRepository.findByEmail(user.getEmail());
                user.setLoggedIn(true);
                model.addAttribute("user", user);
                return "redirect:/user/home";
            }
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }

    @GetMapping("/home")
    @Transactional
    public String home(HttpSession session, Model model) {

        try {
            User user = (User) session.getAttribute("user");
            if (user.isLoggedIn()) {
                model.addAttribute("user", user);
                return "home/home";
            }
        } catch (NullPointerException e) {
            return "redirect:/user/login";
        }

        return "redirect:/user/login";
    }



}