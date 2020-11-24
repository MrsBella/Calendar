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


}
