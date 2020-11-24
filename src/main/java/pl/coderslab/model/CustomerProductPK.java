package pl.coderslab.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Embeddable
public class CustomerProductPK implements Serializable {

    @Column(name = "customer_id")
    private Long customer_id;

    @Column(name = "product_id")
    private Long product_id;

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
