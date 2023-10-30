package design.zykus.zykus.clothing.Controller;

import design.zykus.zykus.clothing.Entity.WebAppUser;
import design.zykus.zykus.clothing.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<WebAppUser> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/users")
    public WebAppUser addNewUser(@RequestBody WebAppUser user){
        return this.userService.addNewUser(user);
    }

}
