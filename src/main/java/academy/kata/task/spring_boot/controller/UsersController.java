package academy.kata.task.spring_boot.controller;

import academy.kata.task.spring_boot.model.User;
import academy.kata.task.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String start() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users/index";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String showUsersById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/show";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/users/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.editUser(id, user);
        return "redirect:/users";
    }
    
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
