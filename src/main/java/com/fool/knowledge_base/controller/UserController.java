package com.fool.knowledge_base.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class UserController {
    @GetMapping
    @Operation
    public String aboba(){
        return "Example";
    }
}
