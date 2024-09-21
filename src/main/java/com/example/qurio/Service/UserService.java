package com.example.qurio.Service;

import com.example.qurio.DTOS.UserDto;
import com.example.qurio.Models.User;
import com.example.qurio.Respository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
     private UserRepository userRepository;

    public List<User>getAllUsers(){
       return userRepository.findAll();
    }

    public User createUser(UserDto  userdto){
        User user=new User();
        user.setId(userdto.getId());
        user.setPassword(userdto.getPassword());
        return userRepository.save(user);

    }

    public User Updateuser(Long id,User incomingUser){
        User user= userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if( incomingUser.getId()!=null){
            user.setId(incomingUser.getId());
        }

        if(incomingUser.getPassword()!=null){
            user.setPassword(incomingUser.getPassword());
        }
        return  this.userRepository.save(user);

    }

    public  Boolean deleteuser(Long id){
        try{
            userRepository.deleteById(id);
            return true;

        }
        catch (Exception e){
            return false;
        }
    }
}
