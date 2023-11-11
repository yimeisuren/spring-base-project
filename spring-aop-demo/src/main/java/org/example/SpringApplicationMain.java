package org.example;

import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class SpringApplicationMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringApplicationMain.class);
        UserService userService = applicationContext.getBean(UserService.class);

        User user = userService.findById(1);
        userService.delete(user);
        userService.save(user);
        userService.update(user);

    }
}
