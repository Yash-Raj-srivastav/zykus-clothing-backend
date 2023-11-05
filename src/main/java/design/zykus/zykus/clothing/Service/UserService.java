package design.zykus.zykus.clothing.Service;

import design.zykus.zykus.clothing.DAO.UserRepository;
import design.zykus.zykus.clothing.Entity.WebAppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<WebAppUser> getAllUsers(){
        return this.userRepository.findAll();
    }

    public ResponseEntity<WebAppUser> getSingleUser(int userId){
        return this.userRepository.findById(userId).
                map(existingUser -> ResponseEntity.ok(existingUser))
                .orElse(ResponseEntity.notFound().build());
    }

    public WebAppUser addNewUser(WebAppUser user){
        return this.userRepository.save(user);
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
                    if(user.getUserEmail() != null){
                        existingUser.setUserEmail(user.getUserEmail());
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
                    if(user.getUserName() != null){
                        existingUser.setUserName(user.getUserName());
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
}
