package com.tbp.crud.dao;

import com.tbp.crud.entity.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);
    User updateUser(User user);
    User getById(int id);
    String deleteById(int id);
    List<User> allUsers();
    List<User> allUsersByName();



}
