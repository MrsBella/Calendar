package pl.coderslab.model;

import java.io.Serializable;
import java.util.Objects;

public class CustomerProductId implements Serializable {

    private Long customer;
    private Long product;

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerProductId that = (CustomerProductId) o;
        return Objects.equals(customer, that.customer) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, product);
    }
}
