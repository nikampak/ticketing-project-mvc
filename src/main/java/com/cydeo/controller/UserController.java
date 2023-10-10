package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.AbstractMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService;
    RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO() );
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/create";
    }
//    @PostMapping("/create")
//    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){
//        model.addAttribute("user", new UserDTO() );
//        model.addAttribute("roles", roleService.findAll());
//        userService.save(user);
//        model.addAttribute("users", userService.findAll());
//
//        return "/user/create";
//    }
    @PostMapping("/create")
    public String insertUser(UserDTO user){
        userService.save(user);

        return "redirect:/user/create";
    }
}
