package com.example.jobapi.service;

import com.example.jobapi.repository.UserRepo;
import com.example.jobapi.model.User;
import com.example.jobapi.model.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(user);
    }
}
