package design.zykus.zykus.clothing.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "webappusers")
public class WebAppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String userEmail;
    private int age;
    private String address;
    private int pinCode;
    private String state;
    private String country;

    public WebAppUser() {
        // Public no-args constructor is required by JPA
    }

    public WebAppUser(int userId, String firstName, String lastName, LocalDate dateOfBirth, String userEmail, int age, String address, int pinCode, String state, String country) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.userEmail = userEmail;
        this.age = age;
        this.address = address;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
    }

    public int getUserId(){
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
}