package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "treatments")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private double price;

    private String description;

    @OneToMany(mappedBy = "treatment")
    private List<CustomerTreatment> customerTreatments = new ArrayList<>();

    public Treatment() {
    }

    public Treatment(@NotNull String name, @NotNull double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CustomerTreatment> getCustomerTreatments() {
        return customerTreatments;
    }

    public void setCustomerTreatments(List<CustomerTreatment> customerTreatments) {
        this.customerTreatments = customerTreatments;
    }
}
