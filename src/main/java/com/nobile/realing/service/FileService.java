package com.nobile.realing.service;

import java.util.List;

import com.nobile.realing.entity.File;

public interface FileService {
    File getFile(Long id);
    File saveFile(File file, Long userId);
    File updateFile(Long id, String name);
    void deleteFile(Long id);
    List<File> getFilesByUserId(Long userId);

}
