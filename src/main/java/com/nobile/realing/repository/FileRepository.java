package com.nobile.realing.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nobile.realing.entity.File;

public interface FileRepository extends CrudRepository<File,Long>{
    List<File> getByProfileId(Long userId);
}
