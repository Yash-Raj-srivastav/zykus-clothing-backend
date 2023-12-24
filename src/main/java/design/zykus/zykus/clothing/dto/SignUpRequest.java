package design.zykus.zykus.clothing.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpRequest {

    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private int age;
    private String gender;
    private String address;
    private int pinCode;
    private String state;
    private String country;
}