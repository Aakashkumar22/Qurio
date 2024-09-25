package com.example.qurio.Controllers;

import com.example.qurio.DTOS.UserDto;
import com.example.qurio.Models.User;
import com.example.qurio.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User>getUserbyId(@PathVariable Long  id){
        Optional<User> user=userService.getUserbyId(id);
        return user;
    }

    @PostMapping
    public  User createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PatchMapping
    public  User Updateuser(@PathVariable Long id,@RequestBody User user){
        return userService.Updateuser(id,user);
    }

    @DeleteMapping("/{Id}")

    public Boolean deleteuser(@PathVariable Long id){
        return userService.deleteuser(id);
    }

    @PostMapping("/{userId}/followTag/{TagId}")

    public ResponseEntity<?>followTag(@PathVariable Long userId,Long TagId){
        userService.followTag(userId,TagId);
        return new ResponseEntity<>("User"+userId+" started follwing Tag:"+TagId,HttpStatus.CREATED);
    }




}
