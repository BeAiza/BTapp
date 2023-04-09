package org.BTapp.BudgetTracker.Service;

import org.BTapp.BudgetTracker.model.User;
import org.BTapp.BudgetTracker.model.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// handles business logic to improve the maintainability, modularity, and testability of the application.
@Service
public class UserService {
    @Autowired
    //tells IDE to suppress warning it will be assigned by Spring at runtime
    //@SuppressWarnings("unused")
    private UserRepository userRepository;

    //@Override
    public void save(User user) {
        userRepository.save(user);
    }

    // Find a User object by its ID using the UserRepository.
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
