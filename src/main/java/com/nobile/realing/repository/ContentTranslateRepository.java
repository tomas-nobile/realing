package com.nobile.realing.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nobile.realing.entity.ContentTranslate;

public interface ContentTranslateRepository extends CrudRepository<ContentTranslate,Long>{
    List<ContentTranslate> getByFileId(Long FileId);
}
