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

    public CustomerTreatmentPK getId() {
        return id;
    }

    public void setId(CustomerTreatmentPK id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
