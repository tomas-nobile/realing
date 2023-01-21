package com.nobile.realing.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobile.realing.entity.File;
import com.nobile.realing.service.FileService;

import javax.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/file")
public class FileController {
    FileService FileService;
    
    @GetMapping("/{id}")    
    public ResponseEntity<File> getFile(@PathVariable Long id){
        return new ResponseEntity<File>(FileService.getFile(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")    
    public ResponseEntity<List<File>> getFileByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(FileService.getFilesByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/save/{userId}")
    public ResponseEntity<File> saveFile(@Valid @RequestBody File File, @PathVariable Long userId){
        return new ResponseEntity<>(FileService.saveFile(File,userId), HttpStatus.OK);
    }

    @PutMapping("/{id}") 
    public ResponseEntity<File> updateFile(@Valid @RequestBody File file, @PathVariable Long id){
        return new ResponseEntity<>(FileService.updateFile(id, file.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")  
    public ResponseEntity<File> removeFile( @PathVariable Long id){
        FileService.deleteFile(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
