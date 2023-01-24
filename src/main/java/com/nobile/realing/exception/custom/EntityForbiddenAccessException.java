package com.nobile.realing.exception.custom;

public class EntityForbiddenAccessException extends RuntimeException {
    public EntityForbiddenAccessException(Long userId, Long resourceId, Class<?> entity){
        super();

    }
}
