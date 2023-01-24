package com.nobile.realing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nobile.realing.entity.ContentTranslate;
import com.nobile.realing.entity.File;
import com.nobile.realing.exception.custom.EntityNotFoundException;
import com.nobile.realing.repository.ContentTranslateRepository;
import com.nobile.realing.repository.FileRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContentTranslateServiceImpl implements ContentTranslateService {
    
    ContentTranslateRepository ContentTranslateRepo;
    FileRepository FileRepo;

    @Override
    public ContentTranslate getContentTranslate(Long id){
        Optional<ContentTranslate> ContentTranslate= ContentTranslateRepo.findById(id);
        return ContentTranslateExists(ContentTranslate,id);
    }

    @Override
    public List<ContentTranslate> getContentTranslatesByFileId(Long FileId) {
        List<ContentTranslate> ContentTranslates= ContentTranslateRepo.getByFileId(FileId);
        return ContentTranslates ;
    }

    @Override
    public ContentTranslate saveContentTranslate (ContentTranslate ContentTranslate,Long FileId){
        Optional<File> unwrappedFile= FileRepo.findById(FileId);
        File File= FileServiceImpl.fileExists(unwrappedFile, FileId);
        ContentTranslate.setFile(File);
        return ContentTranslateRepo.save(ContentTranslate);
    }

    @Override
    public void deleteContentTranslate(Long id) {
        ContentTranslateRepo.deleteById(id);
    }

    public static ContentTranslate ContentTranslateExists(Optional<ContentTranslate> ContentTranslate,Long id) throws EntityNotFoundException{
        if(ContentTranslate.isPresent()){
            return ContentTranslate.get();
        }else{
            throw new EntityNotFoundException(id, ContentTranslate.class);
        }
    }
    
}
