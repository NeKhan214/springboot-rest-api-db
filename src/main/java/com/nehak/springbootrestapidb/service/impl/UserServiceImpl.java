package com.nehak.springbootrestapidb.service.impl;

import com.nehak.springbootrestapidb.dto.UserDto;
import com.nehak.springbootrestapidb.entity.User;
import com.nehak.springbootrestapidb.exception.EmailAlreadyExistsException;
import com.nehak.springbootrestapidb.exception.ResourceNotFoundException;
import com.nehak.springbootrestapidb.mapper.UserMapper;
import com.nehak.springbootrestapidb.repository.UserRepository;
import com.nehak.springbootrestapidb.service.UserService;
import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

//    private ModelMapper modelMapper;

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()) {
            throw  new EmailAlreadyExistsException(String.format
                    ("User with email: %s already exists!", userDto.getEmail()));
        }
        User user = UserMapper.MAPPER.mapToUser(userDto);
//        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
//        return modelMapper.map(savedUser, UserDto.class);
        return UserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public User getUserById(String userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String userId) {
//        User user_exist = userRepository.findById(userId).get();
//        user_exist.setUserName(user.getUserName());
//        user_exist.setLastName(user.getLastName());
//        user_exist.setEmail(user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
