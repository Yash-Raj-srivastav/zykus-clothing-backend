package design.zykus.zykus.clothing.Controller;

import design.zykus.zykus.clothing.DAO.UserRepository;
import design.zykus.zykus.clothing.Entity.WebAppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<WebAppUser> getAllUsers(){
        return this.userRepository.findAll();
    }

    @PostMapping("/users")
    public WebAppUser addNewUser(@RequestBody WebAppUser user){
        return this.userRepository.save(user);
    }

}
