package com.example.jobApplicationTracker.service.impl;

import com.example.jobApplicationTracker.dto.LoginRequest;
import com.example.jobApplicationTracker.dto.LoginResponse;
import com.example.jobApplicationTracker.dto.RegisterUserRequest;
import com.example.jobApplicationTracker.dto.UserResponse;
import com.example.jobApplicationTracker.entity.User;
import com.example.jobApplicationTracker.repository.UserRepository;
import com.example.jobApplicationTracker.security.CustomUserDetails;
import com.example.jobApplicationTracker.service.JwtService;
import com.example.jobApplicationTracker.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Override
    public Boolean registerUser(RegisterUserRequest request) {
        User user = mapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User saveUser = userRepository.save(user);
        return !ObjectUtils.isEmpty(saveUser);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if(authenticate.isAuthenticated()){
            CustomUserDetails customUserDetails = (CustomUserDetails)authenticate.getPrincipal();

            String token = jwtService.generateToken(customUserDetails.getUser());

            return LoginResponse.builder()
                    .user(mapper.map(customUserDetails.getUser(), UserResponse.class))
                    .token(token).build();
        }
        return null;
    }


}
