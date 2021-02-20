package com.truong.shop.security;

import com.truong.shop.ddd.user.User;
import com.truong.shop.ddd.user.IUerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class customUserDetailsService implements UserDetailsService {
    private  final IUerService service;
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=service.getByUserName(s);
        if(user==null){
            throw new UsernameNotFoundException(s);
        }
        return new customUserDetails(user);
    }
    public void saveUser(LoginRequest request){
        System.out.println(request.getPassword());
        service.create(User.builder()
                .username(request.getUsername())
                .password(passwordEncoder().encode(request.getPassword()))
                .build());
    }
}
