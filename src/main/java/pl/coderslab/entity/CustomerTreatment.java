package pl.coderslab.entity;

import pl.coderslab.model.CustomerTreatmentId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers_treatments")
@IdClass(CustomerTreatmentId.class)
public class CustomerTreatment {

    @Id
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "treatment_id", referencedColumnName = "id")
    private Treatment treatment;

    private LocalDateTime localDateTime;

    public CustomerTreatment() {
    }

    public CustomerTreatment(Customer customer, Treatment treatment, LocalDateTime localDateTime) {
        this.customer = customer;
        this.treatment = treatment;
        this.localDateTime = localDateTime;
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

    @Override
    public String toString() {
        return "CustomerTreatment: customer: " + customer.getFullName() + "treatment: " + treatment.getName() + "localDateTime: "
                + localDateTime + "\n";
    }
}
