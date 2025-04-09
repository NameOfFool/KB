package com.fool.knowledge_base.controller;

import com.fool.knowledge_base.domain.model.dto.JwtAuthenticationResponse;
import com.fool.knowledge_base.domain.model.dto.SignInRequest;
import com.fool.knowledge_base.domain.model.dto.SignUpRequest;
import com.fool.knowledge_base.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    @Operation(summary = "Sign Up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request){
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    @Operation(summary = "Sign In")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request){
        return authenticationService.signIn(request);
    }
}
