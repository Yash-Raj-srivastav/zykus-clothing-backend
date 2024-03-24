package design.zykus.zykus.clothing.controller;

import design.zykus.zykus.clothing.entities.WebAppUser;
import design.zykus.zykus.clothing.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public Iterable<WebAppUser> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebAppUser> getSingleUser(@PathVariable("id") Long id){
        return this.userService.getSingleUser(id);
    }

    @PostMapping("/")
    public WebAppUser addNewUser(@RequestBody WebAppUser user){
        return this.userService.addNewUser(user);
    }

    @PostMapping("/add_multiple")
    public Iterable<WebAppUser> addMultipleNewUsers(@RequestBody Iterable<WebAppUser> users){
        return userService.addMultipleNewInvoices(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WebAppUser> updateUserDetails(@RequestBody WebAppUser user, @PathVariable("id") Long id){
        return this.userService.updateUserDetails(user, id);
    }
}
