package com.truong.shop.api;

import com.truong.shop.security.LoginRequest;
import com.truong.shop.security.customUserDetailsService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final com.truong.shop.security.jwtUtil jwtUtil;
    private final customUserDetailsService userDetailsService;
    static final String HEADER_STRING = "Authorization";

    @PostMapping("/reg")
    public void reg(@RequestBody LoginRequest request){
        System.out.println("da vao");
        userDetailsService.saveUser(request);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt =jwtUtil.getJwt(authentication);
        System.out.println(jwt);
        return ResponseEntity.ok()
                .header(HEADER_STRING,jwt)
                .build();
    }
}
