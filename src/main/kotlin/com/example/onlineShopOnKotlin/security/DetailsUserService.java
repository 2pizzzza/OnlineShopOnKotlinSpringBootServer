package com.example.onlineShopOnKotlin.security;

import com.example.onlineShopOnKotlin.entity.User;
import com.example.onlineShopOnKotlin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class DetailsUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = Optional.of(userRepository.findByEmail(email));
        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new DetailsUser(user.get());
    }
}
