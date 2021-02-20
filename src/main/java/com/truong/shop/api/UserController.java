package com.truong.shop.api;

import com.truong.shop.ddd.user.User;
import com.truong.shop.ddd.user.IUerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
@RequiredArgsConstructor
public class UserController {
    private final IUerService uerService;
    @PutMapping
    public void update(@RequestBody User user){
        uerService.update(user);
    }
    @DeleteMapping
    public void deleteById(int id){
        uerService.deleteById(id);
    }
}
