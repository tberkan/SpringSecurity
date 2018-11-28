package com.endava.SpringSecurity;

import com.endava.SpringSecurity.dao.RoleDao;
import com.endava.SpringSecurity.model.Role;
import com.endava.SpringSecurity.model.User;
import com.endava.SpringSecurity.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    private Logger logger = LoggerFactory.getLogger(SpringSecurityApplication.class);

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserServiceI userService;

    @Override
    public void run(String... args) {
        logger.info("Starting Spring Boot app");
        Role role = new Role("ROLE_USER");
        roleDao.save(role);

        logger.info("Role saved");

        logger.info("Adding a USER");
        //password is actually "password"
        User user = new User("username", "$2y$12$fDn63An8qVNi4wiMYOC.SemE.W7w8PaJl9OMbhTHGV4crofl2t5Um/$2y", "user@mail.com", true, role);
        userService.save(user);
        logger.info("User added");

        logger.info("Adding new ROLE");
        Role admin = new Role("ROLE_ADMIN");
        roleDao.save(admin);

        logger.info("Admin added");

        logger.info("Adding a USER");
        User user1 = new User("user_admin", "admin", "admin@mail.com", true, admin);
        userService.save(user1);
        logger.info("User added");

    }
}
