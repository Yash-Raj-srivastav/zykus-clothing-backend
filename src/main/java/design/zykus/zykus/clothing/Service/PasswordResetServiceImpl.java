package design.zykus.zykus.clothing.Service;

import design.zykus.zykus.clothing.Entity.PasswordResetToken;
import design.zykus.zykus.clothing.Entity.WebAppUser;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetServiceImpl implements PasswordResetService{

    @Override
    public void createPasswordResetTokenForUser(WebAppUser user, String token) {

    }

    @Override
    public PasswordResetToken getPasswordResetToken(String token) {
        return null;
    }

    @Override
    public void changeUserPassword(WebAppUser user, String password) {

    }

    @Override
    public WebAppUser findByEmail(String email) {
        return null;
    }
}
