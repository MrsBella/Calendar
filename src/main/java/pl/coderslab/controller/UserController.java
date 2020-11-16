package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "registration/form";
    }
}
