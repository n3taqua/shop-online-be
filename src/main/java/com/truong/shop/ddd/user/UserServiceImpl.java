package com.truong.shop.ddd.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUerService {
    private final IUserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public User getByUserName(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void deleteById(int  id) {
        repository.deleteById(id);
    }
}
