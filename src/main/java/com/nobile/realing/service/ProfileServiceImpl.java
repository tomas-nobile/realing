package com.nobile.realing.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nobile.realing.entity.Profile;
import com.nobile.realing.exception.custom.EntityNotFoundException;
import com.nobile.realing.repository.ProfileRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {


    ProfileRepository profileRepo;


    @Override
    public Profile getProfile(Long id){
        Optional<Profile> profile= profileRepo.findById(id);
        return profileExists(profile,id);
    }

    public static Profile profileExists(Optional<Profile> profile,Long id)  {
        if(profile.isPresent()){
            return profile.get();
        }else{
            throw new EntityNotFoundException(id, Profile.class);
        }
    }
    
}