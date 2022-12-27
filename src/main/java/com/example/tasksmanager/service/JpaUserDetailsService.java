package com.example.tasksmanager.service;

import com.example.tasksmanager.model.RegistrationRequest;
import com.example.tasksmanager.model.Role;
import com.example.tasksmanager.model.SecurityUser;
import com.example.tasksmanager.model.User;
import com.example.tasksmanager.repository.RoleRepository;
import com.example.tasksmanager.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(value = Transactional.TxType.SUPPORTS)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }

    @Transactional
    public User registerUser(RegistrationRequest request) {
        boolean userExists = userRepository.findByUsername(request.getUsername()).isPresent();

        if (userExists) {
            throw new IllegalStateException("User " + request.getUsername() + " already exists");
        }

        Role userRole = roleRepository.findByRoleName("ROLE_USER");
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRoles(Collections.singletonList(userRole));
        userRole.addUserToRole(newUser);

        return userRepository.save(newUser);
    }
}
