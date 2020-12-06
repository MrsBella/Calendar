package pl.coderslab.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String capacity;

    private double price;

    @OneToMany(mappedBy = "product")
    private List<CustomerProduct> customerProducts = new ArrayList<>();

    @ManyToOne
    private User user;

    public Product() {
    }

    public Product(String name, String capacity, double price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<CustomerProduct> getCustomerProducts() {
        return customerProducts;
    }

    public void setCustomerProducts(List<CustomerProduct> customerProducts) {
        this.customerProducts = customerProducts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
