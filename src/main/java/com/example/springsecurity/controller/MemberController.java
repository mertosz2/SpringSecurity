package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController
@RequestMapping("/member")
public class MemberController {

    @PreAuthorize("hasAnyAuthority('READ_MEMBER') or hasRole('ADMIN')")
    @GetMapping("")
    public String greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Member resource";
    }

    @PutMapping("")
    public String editmember(){
        return "edit member";
    }
}
