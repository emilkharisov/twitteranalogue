package ru.knitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.knitu.model.User;
import ru.knitu.repository.MessageRepository;
import ru.knitu.security.details.UserDetailsImpl;
import ru.knitu.service.AddMessageService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    AddMessageService addMessageService;
    @Autowired
    MessageRepository messageRepository;
    @Value("${upload.path}")
    String uploadPath;
    @GetMapping("/")
    public String getMainPage(Authentication authentication, ModelMap model){
        if(authentication==null) {
            return "redirect:/login";
        }
        UserDetailsImpl userDetails =  (UserDetailsImpl)authentication.getPrincipal();
        User user = new User();
        user= userDetails.getUser();
        model.addAttribute("user",user);
        model.addAttribute("message",messageRepository.findAll());
        return "main";
    }
    @PostMapping("/")
    public String writeMessage(ModelMap model, String text, Authentication authentication, @RequestParam("file") MultipartFile file) throws IOException {
        String resultFileName = null;
        if(file!=null && !file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            resultFileName = uuidFile+"."+file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/"+ resultFileName ));
        }
        UserDetailsImpl userDetails =  (UserDetailsImpl)authentication.getPrincipal();
        User user = new User();
        user = userDetails.getUser();
        model.addAttribute("text",text);
        if(text.isEmpty()){
            model.addAttribute("error",true);
            model.addAttribute("user",user);
            model.addAttribute("message",messageRepository.findAll());
            return "main";
        }
        addMessageService.addMessgae(text,user,resultFileName);
        model.addAttribute("user",user);
        model.addAttribute("message",messageRepository.findAll());
        return "main";
    }
}
