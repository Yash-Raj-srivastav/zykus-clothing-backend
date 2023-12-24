package design.zykus.zykus.clothing.services;

import design.zykus.zykus.clothing.dto.JwtAuthenticationResponse;
import design.zykus.zykus.clothing.dto.RefreshTokenRequest;
import design.zykus.zykus.clothing.dto.SignInRequest;
import design.zykus.zykus.clothing.dto.SignUpRequest;
import design.zykus.zykus.clothing.entities.WebAppUser;

public interface AuthenticationService {

    WebAppUser signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
