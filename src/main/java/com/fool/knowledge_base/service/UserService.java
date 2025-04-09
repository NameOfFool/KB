package com.fool.knowledge_base.service;

import com.fool.knowledge_base.domain.model.User;
import com.fool.knowledge_base.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User create(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Пользователь с такой почтой уже существует");
        }
        if(userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        return save(user);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }
    public UserDetailsService userDetailsService(){
        return this::getUserByUsername;
    }
    public User getCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUsername(username);
    }
}
