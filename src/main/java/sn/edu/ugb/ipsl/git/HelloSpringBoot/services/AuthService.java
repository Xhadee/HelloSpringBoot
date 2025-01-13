package sn.edu.ugb.ipsl.git.HelloSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.Authentification;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.entities.User;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.AuthentificationRepository;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.repositories.UserRepository;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class AuthService {

    private static final String TOKEN_CHAR = "0123456789qwertyuiopasdfghjklmzxcvbnQWERTYUIOPASDFGHJKLMNBVCXZ";

    private static final int TOKEN_LENGTH = 50;

    @Autowired
    private AuthentificationRepository authentificationRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<Authentification> login(String email,String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                Authentification authentification = new Authentification();
                authentification.setUser(user.get());
                Date now = new Date();
                authentification.setNotBefore(now);
                Date notAfter = new Date(now.getTime() + 24 * 60 * 60 * 1000);
                authentification.setNotAfter(notAfter);

            }
        }

        return Optional.empty();
    }

    //public String generateToken() {
       // String Token=
    }
}
