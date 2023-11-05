//package design.zykus.zykus.clothing.Entity;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "passwordResetToken")
//public class PasswordResetToken {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String token;
//
//    @OneToOne(targetEntity = WebAppUser.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "userId")
//    private WebAppUser webAppUser;
//
//    private LocalDateTime expiryDate;
//
//    public boolean isExpired() {
//        return LocalDateTime.now().isAfter(expiryDate);
//    }
//
//    public WebAppUser getUser() {
//        return this.webAppUser;
//    }
//
//}
