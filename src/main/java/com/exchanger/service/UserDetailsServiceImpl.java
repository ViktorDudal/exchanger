package com.exchanger.service;

import com.exchanger.exception.ResourceNotFoundException;
import com.exchanger.model.Credentials;
import com.exchanger.model.User;
import com.exchanger.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String name) {
        User user = userRepository.findByUserName(name)
                .orElseThrow(() -> new ResourceNotFoundException("user", "name", name));

        return new Credentials(user);
    }
}
