package com.truong.shop.ddd.user;

public interface IUerService {
    void save(User user);
    User getById(int id);
    User getByUserName(String username);
    void create(User user);
    void update(User user);
    void deleteById(int id);
}
