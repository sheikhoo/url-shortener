package ir.sheikhoo.url_shortener.modules.user.service;

import ir.sheikhoo.url_shortener.modules.user.model.Users;
import ir.sheikhoo.url_shortener.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public void registerUser(Users users){
        if(!users.getPassword().isEmpty())
            users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
        userRepository.save(users);
    }

    public long numberUser() {
        return userRepository.count();
    }

    public Users findUser(String email) {
        return userRepository.findUser(email);
    }
}
