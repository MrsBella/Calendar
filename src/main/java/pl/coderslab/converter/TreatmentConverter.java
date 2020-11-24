package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Treatment;
import pl.coderslab.repository.TreatmentRepository;

import javax.persistence.EntityNotFoundException;

public class TreatmentConverter implements Converter<String, Treatment> {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Override
    public Treatment convert(String s) {
        long id = Long.parseLong(s);
        return treatmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Treatment not found." +
                "Id: " + s));
    }
}
