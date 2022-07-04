package lukas.cerusteste.resource;

import lukas.cerusteste.model.User;
import lukas.cerusteste.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser (@RequestBody User userToBeAdded){
        User newUser = userService.addUser(userToBeAdded);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}
