package com.nobile.realing.service;

import java.util.List;

import com.nobile.realing.entity.ContentTranslate;

public interface ContentTranslateService {
    ContentTranslate getContentTranslate(Long id) ;
    ContentTranslate saveContentTranslate(ContentTranslate ContentTranslate, Long fileId);
    void deleteContentTranslate(Long id);
    List<ContentTranslate> getContentTranslatesByFileId(Long fileId);

}
