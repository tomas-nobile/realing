package com.nobile.realing.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nobile.realing.entity.User;
import com.nobile.realing.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    
    UserRepository userRepo;

    @Override
    public User getUser(Long id) {
        Optional<User> user= userRepo.findById(id);
        return userExists(user,id);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public static User userExists(Optional<User> user,Long id){
        if(user.isPresent()){
            return user.get();
        }else{
            throw new RuntimeException();
        }
    }
    
}
