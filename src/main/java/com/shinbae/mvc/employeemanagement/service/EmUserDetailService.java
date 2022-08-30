package com.shinbae.mvc.employeemanagement.service;

import com.shinbae.mvc.employeemanagement.entity.User;
import com.shinbae.mvc.employeemanagement.pojo.EmUserDetails;
import com.shinbae.mvc.employeemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        return new EmUserDetails(user);
    }
}
