package design.zykus.zykus.clothing.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserResponse {
    private Long userId;
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String gender;
    private String address;
    private int pinCode;
    private String state;
    private String country;
}
