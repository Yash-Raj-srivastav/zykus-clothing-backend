package design.zykus.zykus.clothing.Service;

import design.zykus.zykus.clothing.DAO.UserRepository;
import design.zykus.zykus.clothing.Entity.WebAppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<WebAppUser> getAllUsers(){
        return this.userRepository.findAll();
    }

    public WebAppUser addNewUser(WebAppUser user){
        return this.userRepository.save(user);
    }
}
