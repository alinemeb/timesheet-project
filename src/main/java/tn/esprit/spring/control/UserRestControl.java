package tn.esprit.spring.control;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserRestControl {

    private final IUserService userService;

    // Injection par constructeur (corrige le problème de field injection)
    public UserRestControl(IUserService userService) {
        this.userService = userService;
    }

    // URL : http://localhost:8080/user/retrieve-all-users
    @GetMapping("/retrieve-all-users")
    public List<User> retrieveAllUsers() {
        return userService.retrieveAllUsers();
    }

    // URL : http://localhost:8080/user/retrieve-user/{user-id}
    @GetMapping("/retrieve-user/{user-id}")
    public User retrieveUser(@PathVariable("user-id") String userId) {
        return userService.retrieveUser(userId);
    }

    // URL : http://localhost:8080/user/add-user
    @PostMapping("/add-user")
    public User addUser(@RequestBody User u) {
        return userService.addUser(u);
    }

    // URL : http://localhost:8080/user/remove-user/{user-id}
    @DeleteMapping("/remove-user/{user-id}")
    public void removeUser(@PathVariable("user-id") String userId) {
        userService.deleteUser(userId);
    }

    // URL : http://localhost:8080/user/modify-user
    @PutMapping("/modify-user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
