package com.example.securityjwt;

import com.example.securityjwt.domain.Role;
import com.example.securityjwt.domain.User;
import com.example.securityjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Jone Doe", "john", "1234", new ArrayList()));
            userService.saveUser(new User(null, "Jane Doe", "jane", "1234", new ArrayList()));
            userService.saveUser(new User(null, "Tim Doe", "tim", "1234", new ArrayList()));
            userService.saveUser(new User(null, "Marry Doe", "marry", "1234", new ArrayList()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("john", "ROLE_MANAGER");
            userService.addRoleToUser("jane", "ROLE_MANAGER");
            userService.addRoleToUser("tim", "ROLE_ADMIN");
            userService.addRoleToUser("marry", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("marry", "ROLE_ADMIN");
            userService.addRoleToUser("marry", "ROLE_USER");

        };
    }
}
