package com.example.jobapi.service;

import com.example.jobapi.repository.UserRepo;
import com.example.jobapi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);

    public User register(User user)
    {
        user.setPassword(bcrypt.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
