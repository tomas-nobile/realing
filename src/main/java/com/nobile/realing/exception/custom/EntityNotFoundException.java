package com.nobile.realing.exception.custom;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id, Class<?> entity) { 
        super("The " + entity.getSimpleName().toLowerCase() + " with id '" + id + "' does not exist in our records");
}

public EntityNotFoundException(String name, Class<?> entity) { 
    super("The " + entity.getSimpleName().toLowerCase() + " '" + name + "' does not exist in our records");
}
}   