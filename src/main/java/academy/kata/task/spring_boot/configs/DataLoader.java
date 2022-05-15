package academy.kata.task.spring_boot.configs;

import academy.kata.task.spring_boot.model.User;
import academy.kata.task.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserService userService;

    @Autowired
    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    public void run(ApplicationArguments args) {
        userService.saveUser(new User("Ivan", "Pushkin", (byte)65));
        userService.saveUser(new User("Petr", "Ylanov", (byte)24));
    }
}