package arp.project.spring.learnspringboot.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserDetailsRepository userDetailsRepository;

    public UserDetailsCommandLineRunner(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(Arrays.toString(args));
        userDetailsRepository.save(new UserDetails("arun", "Admin"));
        userDetailsRepository.save(new UserDetails("ravi", "Admin"));
        userDetailsRepository.save(new UserDetails("john", "User"));

        List<UserDetails> users = userDetailsRepository.findAll();
        users.forEach(user -> logger.info(user.toString()));

        List<UserDetails> adminUsers = userDetailsRepository.findByRole("Admin");
        adminUsers.forEach(user -> logger.info(user.toString()));
    }
}
