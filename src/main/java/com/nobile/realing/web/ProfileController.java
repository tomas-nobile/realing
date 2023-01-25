package com.nobile.realing.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobile.realing.entity.Profile;
import com.nobile.realing.service.ProfileService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/profile")
public class ProfileController {
    ProfileService profileService;

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        return new ResponseEntity<Profile>(profileService.getProfile(id), HttpStatus.OK);
    }


}
