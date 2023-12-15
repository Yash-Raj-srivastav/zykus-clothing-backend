package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.entities.PasswordResetToken;
import design.zykus.zykus.clothing.entities.WebAppUser;
import design.zykus.zykus.clothing.services.PasswordResetService;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {

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
