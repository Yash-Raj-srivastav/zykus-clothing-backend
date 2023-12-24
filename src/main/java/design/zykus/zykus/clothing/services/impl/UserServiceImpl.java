package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.repository.UserRepository;
import design.zykus.zykus.clothing.entities.WebAppUser;
import design.zykus.zykus.clothing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<WebAppUser> getAllUsers(){
        return this.userRepository.findAll();
    }

    public ResponseEntity<WebAppUser> getSingleUser(int userId){
        return this.userRepository.findById(userId).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public WebAppUser addNewUser(WebAppUser user){
        return this.userRepository.save(user);
    }

    public Iterable<WebAppUser> addMultipleNewInvoices(Iterable<WebAppUser> users){
        return userRepository.saveAll(users);
    }

    public ResponseEntity<WebAppUser> updateUserDetails(WebAppUser user, int userId){
        return userRepository.findById(userId).
                map(existingUser -> {
                    // Update only the non-null fields from the updatedUser
                    if (user.getFirstName() != null) {
                        existingUser.setFirstName(user.getFirstName());
                    }
                    if (user.getLastName() != null) {
                        existingUser.setLastName(user.getLastName());
                    }
                    if(user.getDateOfBirth() != null){
                        existingUser.setDateOfBirth(user.getDateOfBirth());
                    }
                    if(user.getEmail() != null){
                        existingUser.setEmail(user.getEmail());
                    }
                    if(user.getAge() >= 12){
                        existingUser.setAge(user.getAge());
                    }
                    if(user.getAddress() != null){
                        existingUser.setAddress(user.getAddress());
                    }
                    if(user.getState() != null){
                        existingUser.setState(user.getState());
                    }
                    if(user.getPinCode() >= 100000 && user.getPinCode() <= 999999){
                        existingUser.setPinCode(user.getPinCode());
                    }
                    if(user.getCountry() != null){
                        existingUser.setCountry(user.getCountry());
                    }
                    if(user.getUsername() != null){
                        existingUser.setUserName(user.getUsername());
                    }
                    if(user.getGender() != null){
                        existingUser.setGender(user.getGender());
                    }
                    WebAppUser savedUser = userRepository.save(existingUser);
                    return ResponseEntity.ok(savedUser);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<WebAppUser> deleteExistingUser(@PathVariable("userId") Integer userId){
        return userRepository.findById(userId)
                .map(existingUser -> {
                    WebAppUser deletedUser = null;
                    if(existingUser.getUserId() == userId){
                        deletedUser = existingUser;
                        userRepository.deleteById(userId);
                    }
                    return ResponseEntity.ok(deletedUser);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found!!!"));
            }
        };
    }
}
