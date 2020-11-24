package pl.coderslab.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerTreatmentPK implements Serializable {

    @Column(name = "customer_id")
    private Long customer_id;

    @Column(name = "treatment_id")
    private Long treatment_id;

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getTreatment_id() {
        return treatment_id;
    }

    public void setTreatment_id(Long treatment_id) {
        this.treatment_id = treatment_id;
    }
}
