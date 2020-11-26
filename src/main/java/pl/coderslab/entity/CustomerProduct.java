package pl.coderslab.entity;

import pl.coderslab.model.CustomerProductId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers_products")
@IdClass(CustomerProductId.class)
public class CustomerProduct {

    @Id
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private LocalDateTime localDateTime;

    public CustomerProduct() {
    }

    public CustomerProduct(Customer customer, Product product, LocalDateTime localDateTime) {
        this.customer = customer;
        this.product = product;
        this.localDateTime = localDateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
