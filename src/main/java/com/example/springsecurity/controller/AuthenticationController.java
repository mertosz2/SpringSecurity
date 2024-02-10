package com.example.springsecurity.controller;

import com.example.springsecurity.model.UserAuthen;
import com.example.springsecurity.service.AuthenticationUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final AuthenticationUserDetailService authenticationUserDetailService;

    @PostMapping("/authenticate")
    public String  authentication(@RequestBody UserAuthen request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        return authenticationUserDetailService.generateJwt(request.getUsername());
    }
}
