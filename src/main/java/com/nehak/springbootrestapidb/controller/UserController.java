package com.nehak.springbootrestapidb.controller;

import com.nehak.springbootrestapidb.dto.UserDto;
import com.nehak.springbootrestapidb.entity.User;
import com.nehak.springbootrestapidb.exception.ResourceNotFoundException;
import com.nehak.springbootrestapidb.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "UserResource CRUD APIs",
        description = "CRUD Rest API - Create User, Get Users, Update User, Delete User"
)
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @Operation(
            summary = "Create User Rest API",
            description = "Creates a user and save to internal database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status Code 201 Created"
    )
    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto userDto1 =  userService.createUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User Detail By Id Rest API",
            description = "Fetches user details by userId"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 OK"
    )
    @GetMapping("{id}/getUserById")
    public ResponseEntity<User> getUserById(@PathVariable("id") String userId) throws ResourceNotFoundException {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Users Details Rest API",
            description = "Fetches all user details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 OK"
    )
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Operation(
            summary = "Update User Details Rest API",
            description = "Update user details by verifying the Id param"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 OK"
    )
    @PutMapping("{id}/updateUser")
    public ResponseEntity<User> updateUser(@PathVariable("id") String userId, @RequestBody @Valid User user) {
        user.setId(userId);
        return new ResponseEntity<>(userService.updateUser(user, userId), HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User Details Rest API",
            description = "Delete user details by verifying the Id param"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 OK"
    )
    @DeleteMapping("{id}/deleteUser")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully deleted!!", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
//                                                                        WebRequest webRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                resourceNotFoundException.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
