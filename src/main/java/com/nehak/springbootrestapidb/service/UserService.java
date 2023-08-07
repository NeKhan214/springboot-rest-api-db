package com.nehak.springbootrestapidb.service;

import com.nehak.springbootrestapidb.dto.UserDto;
import com.nehak.springbootrestapidb.entity.User;
import com.nehak.springbootrestapidb.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto user);
    public User getUserById(String userId) throws ResourceNotFoundException;
    public List<User> getAllUsers();
    public User updateUser(User user, String userId);
    public void deleteUser(String userId);
}
