package pl.coderslab.model;

import java.io.Serializable;
import java.util.Objects;

public class CustomerTreatmentId implements Serializable {

    private Long customer;
    private Long treatment;

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Long getTreatment() {
        return treatment;
    }

    public void setTreatment(Long treatment) {
        this.treatment = treatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerTreatmentId that = (CustomerTreatmentId) o;
        return Objects.equals(customer, that.customer) &&
                Objects.equals(treatment, that.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, treatment);
    }
}
