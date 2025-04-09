package com.fool.knowledge_base.service;

import com.fool.knowledge_base.domain.model.Role;
import com.fool.knowledge_base.domain.model.User;
import com.fool.knowledge_base.domain.model.dto.JwtAuthenticationResponse;
import com.fool.knowledge_base.domain.model.dto.SignInRequest;
import com.fool.knowledge_base.domain.model.dto.SignUpRequest;
import com.fool.knowledge_base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public JwtAuthenticationResponse signUp(SignUpRequest request){
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        userService.create(user);
        return new JwtAuthenticationResponse(jwtService.generateToken(user.getUsername()));
    }

    public JwtAuthenticationResponse signIn(SignInRequest request){
        authManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()));
        UserDetails user = userService.userDetailsService().loadUserByUsername(request.getUsername());
        return new JwtAuthenticationResponse(jwtService.generateToken(user.getUsername()));
    }
}
