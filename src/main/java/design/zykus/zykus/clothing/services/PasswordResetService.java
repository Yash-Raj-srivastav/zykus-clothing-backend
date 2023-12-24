package design.zykus.zykus.clothing.services;

import design.zykus.zykus.clothing.entities.PasswordResetToken;
import design.zykus.zykus.clothing.entities.WebAppUser;

public interface PasswordResetService {
    void createPasswordResetTokenForUser(WebAppUser user, String token);
    PasswordResetToken getPasswordResetToken(String token);
    void changeUserPassword(WebAppUser user, String password);
    WebAppUser findByEmail(String email);
}
