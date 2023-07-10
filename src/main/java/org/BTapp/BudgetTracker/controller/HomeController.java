package org.BTapp.BudgetTracker.controller;

import org.BTapp.BudgetTracker.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/home")
public class HomeController {

    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public ResponseEntity<String> home() {
        return ResponseEntity.ok(homeService.getWelcomeMessage());
    }


}
