package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.knitu.model.Role;
import ru.knitu.model.User;
import ru.knitu.repository.UserRepository;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
public class UsersController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public String getUsersPage(ModelMap model) {
        model.addAttribute("users",userRepository.findAll());
        return "users";
    }
    @PostMapping("filter")
    public String findByFirst(@RequestParam String firstname,ModelMap model)
    {

        if(firstname.isEmpty()) {
            model.addAttribute("users",userRepository.findAll());
        }
        else {
            model.addAttribute("users", userRepository.findAllByFirstname(firstname));
        }
        return "users";
    }

    //----------------------------------------------------------------------------------------------

    @GetMapping("/edit/{user}")
    public String getPage(ModelMap model, @PathVariable User user){
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "editUser";
    }
    @PostMapping("/edit")
    public String editUser(@RequestParam String login, @RequestParam("userId") User user, @RequestParam Map<String,String> form ) {
        user.setLogin(login);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.setRole(Role.valueOf(key));
            }
        }
        userRepository.save(user);
        return "redirect:/users";
    }
}
