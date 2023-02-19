package arp.project.spring.learnspringboot.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String userName, String password) {
        boolean isValidUserName = userName.equals("arun");
        boolean isValidPassword = password.equals("dummy");
        return isValidUserName && isValidPassword;
    }
}
