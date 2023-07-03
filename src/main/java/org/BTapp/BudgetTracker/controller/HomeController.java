package org.BTapp.BudgetTracker.controller;

import org.BTapp.BudgetTracker.Service.HomeService;
import org.BTapp.BudgetTracker.model.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping
    public List<Home> getAllHomes() {
        return homeService.getAllHomes();
    }

    @PostMapping
    public Home createHome(@RequestBody Home home) {
        return homeService.createHome(home);
    }

}
