package design.zykus.zykus.clothing.entities;

import design.zykus.zykus.clothing.dto.ProductInCartRequest;
import design.zykus.zykus.clothing.dto.ProductInWishListRequest;
import design.zykus.zykus.clothing.utils.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "webappusers")
public class WebAppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;
    private String userPassword;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private int age;
    private String gender;
    private String address;
    private int pinCode;
    private String state;
    private String country;
    private Role role;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductInWishListRequest> productInWishList;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Order> order;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductInCartRequest> productInCartRequests;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}