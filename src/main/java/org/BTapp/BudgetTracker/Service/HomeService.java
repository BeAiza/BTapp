package org.BTapp.BudgetTracker.Service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String getWelcomeMessage() {
        // Your business logic goes here. This is a very basic example.
        return "Welcome to SpendWise!";
    }
}