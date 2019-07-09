package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.knitu.form.UserForm;
import ru.knitu.service.SignUpService;

@Controller
public class SignUpController  {
    @Autowired
    SignUpService signUpService;
    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp";
    }
    @PostMapping("/signUp")
    public String signUpUser(UserForm userForm, ModelMap model){
        if(userForm.getFirstName().isEmpty() || userForm.getLastName().isEmpty() || userForm.getLogin().isEmpty() || userForm.getPassword().isEmpty() || userForm.getTelephone().isEmpty())
        {
            model.addAttribute("error",true);
            return "/signUp";
        }
        signUpService.signUp(userForm);
        return "redirect:/login";
    }
}
