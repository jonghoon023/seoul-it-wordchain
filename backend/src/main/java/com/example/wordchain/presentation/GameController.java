package com.example.wordchain.presentation;

import com.example.wordchain.application.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private UserRepository userRepository;

    @PostMapping("/players")
    public JoinResponse join(@RequestBody String userName) {
        String userId = userRepository.create(userName);
        return new JoinResponse(userId);
    }
}
