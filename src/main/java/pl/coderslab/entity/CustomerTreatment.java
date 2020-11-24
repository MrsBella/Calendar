package pl.coderslab.entity;

import pl.coderslab.model.CustomerTreatmentPK;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers_treatments")
public class CustomerTreatment implements Serializable {

    @EmbeddedId
    private CustomerTreatmentPK id;

    @ManyToOne
    @MapsId("customer_id")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("treatment_id")
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    private LocalDateTime localDateTime;

    public CustomerTreatment() {
    }
}
