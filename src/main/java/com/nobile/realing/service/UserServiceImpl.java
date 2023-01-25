package com.nobile.realing.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nobile.realing.entity.Profile;
import com.nobile.realing.entity.User;
import com.nobile.realing.exception.custom.EntityNotFoundException;
import com.nobile.realing.repository.ProfileRepository;
import com.nobile.realing.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    UserRepository userRepo;
    ProfileRepository profileRepo;

    @Override
    public User getUser(Long id){
        Optional<User> user= userRepo.findById(id);
        return userExists(user,id);
    }

    @Override
    public User getUser(String email){
        Optional<User> user= userRepo.findByEmail(email);
        return userExists(user,email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save( user);
        Profile profile= new Profile();
        profile.setUser(user);
        profileRepo.save(profile);
    }

    public static User userExists(Optional<User> user,Long id)  {
        if(user.isPresent()){
            return user.get();
        }else{
            throw new EntityNotFoundException(id, User.class);
        }
    }
    
    public static User userExists(Optional<User> user,String name) {
        if(user.isPresent()){
            return user.get();
        }else{
            throw new EntityNotFoundException(name, User.class);
        }
    }
}
