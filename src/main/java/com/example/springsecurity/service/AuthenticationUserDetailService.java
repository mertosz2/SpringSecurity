package com.example.springsecurity.service;

import com.example.springsecurity.config.CustomUserDetail;
import com.example.springsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    private final JwtService jwtService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }

    public String generateJwt(String username){
        CustomUserDetail userDetails = userRepository.findUserByUsername(username);
        return jwtService.generateToken(userDetails);
    }
}
