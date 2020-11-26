package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid User user, BindingResult bindingResult) {
        if ((userRepository.findByEmail(user.getEmail())) == null) {
            if (bindingResult.hasErrors()) {
                return "user/form";
            } else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(user);
            }
        } else {
            return "user/exception";
        }
        return "user/hello";
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
    public String processLogin(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        } else {

        }
        return "user/hello";
    }
}