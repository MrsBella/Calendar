package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Treatment;
import pl.coderslab.repository.TreatmentRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/treatment")
public class TreatmentController {

    private final TreatmentRepository treatmentRepository;

    public TreatmentController(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("treatment", new Treatment());
        return "treatment/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Treatment treatment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "treatment/form";
        } else {
            treatmentRepository.save(treatment);
        }
        return "redirect:/treatment/list";
    }

    @GetMapping("/list/{id}")
    public String list(@PathVariable Long id, Model model) {
        List<Treatment> treatments = treatmentRepository.findAllByUserId(id);
        model.addAttribute("treatments", treatments);
        return "treatment/list";
    }

    @GetMapping("form/{id}")
    @Transactional
    public String form(@PathVariable long id, Model model) {
        Optional<Treatment> treatment = treatmentRepository.findById(id);
        Treatment foundTreatment = treatment.orElseThrow(() -> new EntityNotFoundException("Treatment not found"));
        model.addAttribute("treatment", foundTreatment);
        return "treatment/update";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        return "treatment/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        treatmentRepository.deleteById(id);
        return "redirect:/treatment/list";
    }
}
