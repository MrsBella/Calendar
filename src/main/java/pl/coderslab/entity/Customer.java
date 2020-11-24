package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String email;

    @NotNull
    private int phoneNumber;

    private String note;

    @ManyToMany(mappedBy = "customers")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "treatment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CustomerTreatment> customerTreatments = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(name = "customers_treatments",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "treatment_id"))
//    private List<Treatment> treatments = new ArrayList<>();

    public Customer() {
    }

    public Customer(Long id, @NotNull String firstName, @NotNull String lastName, String email,
                    @NotNull int phoneNumber, String note, List<Employee> employees) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.employees = employees;
    //    this.customerTreatments = customerTreatments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

//    public List<Treatment> getTreatments() {
//        return treatments;
//    }
//
//    public void setTreatments(List<Treatment> treatments) {
//        this.treatments = treatments;
//    }
}
