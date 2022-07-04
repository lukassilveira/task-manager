package lukas.cerusteste.service;

import lukas.cerusteste.model.User;
import lukas.cerusteste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User userToBeAdded){
        return userRepository.save(userToBeAdded);
    }
}
