package arp.project.spring.learnspringboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or Database for storing credentials
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("arun")
                .password("dummy")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
