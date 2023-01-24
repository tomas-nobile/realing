package com.nobile.realing.security.utils;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nobile.realing.entity.User;

public class Util {

    public static User verifyPayloadStruct(HttpServletRequest request){
        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return user; 
        } catch (Exception e) {
            throw new RuntimeException("Bad Request. Please check request's body out");
        } 
    }
    
}
