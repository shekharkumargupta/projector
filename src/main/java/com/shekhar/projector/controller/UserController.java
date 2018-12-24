package com.shekhar.projector.controller;

import com.shekhar.projector.domain.Project;
import com.shekhar.projector.dto.UserDTO;
import com.shekhar.projector.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shekhar.kumar on 10/26/2018.
 */
@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public ModelAndView loadUserScreen(){
        ModelAndView model = new ModelAndView("user");
        model.addObject("message", "Hello Guest");
        return model;
    }

    @GetMapping("/{name}")
    public ModelAndView loadUserScreen(@PathVariable("name") String name){
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach(projects::add);

        ModelAndView model = new ModelAndView("user");
        model.addObject("message", "Hello "+name+"!");
        model.addObject("projects", projects);
        return model;
    }

    @GetMapping(value = "/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping(value = "/registration")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO accountDto,
            BindingResult result, WebRequest request, Errors errors) {
        System.out.println(accountDto);
        String registeredEmail = "shekhar@gmail.com";

        if (!result.hasErrors()) {
            System.out.println("User Registerd: "+accountDto);
            return new ModelAndView("successRegister", "user", accountDto);
        }
        if(result.hasErrors()){
            result.rejectValue("email", "message.regError");
        }
        if (accountDto.getFirstName().equals(registeredEmail)) {
            result.rejectValue("email", "message.regError");
        }
        return null;
    }




}