package design.zykus.zykus.clothing.Controller;

import design.zykus.zykus.clothing.Entity.WebAppUser;
import design.zykus.zykus.clothing.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v2/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Iterable<WebAppUser> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebAppUser> getSingleUser(@PathVariable("id") int id){
        return this.userService.getSingleUser(id);
    }

    @PostMapping("/")
    public WebAppUser addNewUser(@RequestBody WebAppUser user){
        return this.userService.addNewUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WebAppUser> updateUserDetails(@RequestBody WebAppUser user, @PathVariable("id") int id){
        return this.userService.updateUserDetails(user, id);
    }
}
