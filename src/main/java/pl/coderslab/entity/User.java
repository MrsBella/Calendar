package pl.coderslab.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.annotation.PasswordValueMatch;
import pl.coderslab.repository.UserRepository;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//@PasswordValueMatch.List({
//        @PasswordValueMatch(
//                field = "password",
//                fieldMatch = "repeatPassword",
//                message = "Passwords do not match!"
//        )
//})

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 60)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 60)
    private String lastName;

    @NotNull
    @Size(min = 2, max = 120)
    private String companyName;

    @NotNull
    @Email
    private String email;

    @Size(max = 60)
    @NotNull
    private String password;

    @Transient
//    @NotNull(groups = User.class)
    private String repeatPassword;

    @Transient
    private boolean loggedIn = false;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany
    @LazyCollection (LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private List<Customer> customers = new ArrayList<>();

    @OneToMany
    @LazyCollection (LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private List<Treatment> treatments = new ArrayList<>();

    @OneToMany
    @LazyCollection (LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private List<Product> products = new ArrayList<>();


    public User(@NotNull @Size(min = 3, max = 60) String firstName, @NotNull @Size(min = 3, max = 60) String lastName,
                @NotNull @Size(min = 2, max = 120) String companyName, @NotNull @Email String email, @Size(max = 60)
                        String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.email = email;
        this.password = password;
      //  this.repeatPassword = repeatPassword;
    }

    public User() {
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Transactional
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + ", loggedIn=" + loggedIn;
    }
}
