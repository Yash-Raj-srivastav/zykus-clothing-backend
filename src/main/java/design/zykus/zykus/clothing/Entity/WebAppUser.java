package design.zykus.zykus.clothing.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "webappusers")
public class WebAppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;
    private String userPassword;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String userEmail;
    private int age;
    private String gender;
    private String address;
    private int pinCode;
    private String state;
    private String country;

    public WebAppUser() {
        // Public no-args constructor is required by JPA
    }

    public WebAppUser(int userId, String userName, String userPassword, String firstName, String lastName, LocalDate dateOfBirth, String userEmail, int age, String gender, String address, int pinCode, String state, String country) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.userEmail = userEmail;
        this.age = age;
        this.gender = gender;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "WebAppUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", userEmail='" + userEmail + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", pinCode=" + pinCode +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

//    public void setUserPassword(String userPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        this.userPassword = passwordEncoder.encode(userPassword);
//    }
//    public boolean isPasswordValid(String inputPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.matches(inputPassword, this.userPassword);
//    }
}