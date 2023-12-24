package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.dto.JwtAuthenticationResponse;
import design.zykus.zykus.clothing.dto.RefreshTokenRequest;
import design.zykus.zykus.clothing.dto.SignInRequest;
import design.zykus.zykus.clothing.dto.SignUpRequest;
import design.zykus.zykus.clothing.utils.Role;
import design.zykus.zykus.clothing.entities.WebAppUser;
import design.zykus.zykus.clothing.repository.UserRepository;
import design.zykus.zykus.clothing.services.AuthenticationService;
import design.zykus.zykus.clothing.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public WebAppUser signup(SignUpRequest signUpRequest){

        WebAppUser user = new WebAppUser();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setMiddleName(signUpRequest.getMiddleName());
        user.setLastName(signUpRequest.getLastName());
        user.setUserName(signUpRequest.getUserName());
        user.setDateOfBirth(signUpRequest.getDateOfBirth());
        user.setAge(signUpRequest.getAge());
        user.setGender(signUpRequest.getGender());
        user.setAddress(signUpRequest.getAddress());
        user.setPinCode(signUpRequest.getPinCode());
        user.setState(signUpRequest.getState());
        user.setCountry(signUpRequest.getCountry());
        user.setRole(Role.USER);
        user.setUserPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signin(SignInRequest signInRequest){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));

        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);

        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){

        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        WebAppUser user = userRepository.findByEmail(userEmail).orElseThrow();

        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)){
            var jwt = jwtService.generateToken(user);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());

            return jwtAuthenticationResponse;
        }
        return null;
    }
}
