package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ProductRepository;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Product product, BindingResult bindingResult, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (bindingResult.hasErrors()) {
            return "product/form";
        } else {
            product.setUser(user);
            productRepository.save(product);
        }
        return "redirect:/product/list/" + user.getId();
    }

    @GetMapping("/list/{id}")
    public String list(@PathVariable Long id, Model model) {
        List<Product> products = productRepository.findAllByUserId(id);
        model.addAttribute("products", products);
        return "product/list";
    }
    @GetMapping("form/{id}")
    @Transactional
    public String form(@PathVariable long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        Product foundProduct = product.orElseThrow(() -> new EntityNotFoundException("Product not found"));
        model.addAttribute("product", foundProduct);
        return "product/update";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        return "product/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        productRepository.deleteById(id);
        return "redirect:/product/list";
    }
}
