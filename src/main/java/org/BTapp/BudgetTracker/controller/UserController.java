package org.BTapp.BudgetTracker.controller;

import org.BTapp.BudgetTracker.Service.UserService;
import org.BTapp.BudgetTracker.model.User;
import org.BTapp.BudgetTracker.model.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUsers() {
        // Return a list of users
        return userService.findAll();
    }


    @GetMapping(value = "/login")
    public String login() {
        return "login";
    } 
    @PostMapping(value = "/user/login")
    public String processLogin() {
        // You should add proper authentication logic here
        // If the login is successful, redirect the user to the budget list page
        return "redirect:/budget/list";
    }

    @GetMapping(value = "/user/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/user/register")
    public String createUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            redirectAttributes.addFlashAttribute("error", "Username already exists.");
            return "redirect:/register";
        }
        userService.save(user);
        return "redirect:/login";
    }


}
