package com.nobile.realing.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobile.realing.entity.ContentTranslate;
import com.nobile.realing.service.ContentTranslateService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;
import lombok.AllArgsConstructor;


@Tag(name = "Content to translate controller", description = "Create or retrive words/phrase to translate")
@AllArgsConstructor
@RestController
@RequestMapping("/ContentTranslate")
public class ContentTranslateController {
    ContentTranslateService ContentTranslateService;

    @Operation(summary = "Retrieves contacts", description = "Provides a list of all contacts")
    @GetMapping("/{id}")    
    public ResponseEntity<ContentTranslate> getContentTranslate(@PathVariable Long id) {
        return new ResponseEntity<ContentTranslate>(ContentTranslateService.getContentTranslate(id), HttpStatus.OK);
    }

    @Operation(summary = "Retrieves contacts", description = "Provides a list of all contacts")
    @PostMapping("/save/{fileId}")
    public ResponseEntity<ContentTranslate> saveContentTranslate(@Valid @RequestBody ContentTranslate ContentTranslate, @PathVariable Long fileId){
        return new ResponseEntity<>(ContentTranslateService.saveContentTranslate(ContentTranslate,fileId), HttpStatus.OK);
    }

    @GetMapping("/file/{fileId}")    
    public ResponseEntity<List<ContentTranslate>> getContentTranslateByFileId(@PathVariable Long fileId){
        return new ResponseEntity<>(ContentTranslateService.getContentTranslatesByFileId(fileId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")  
    public ResponseEntity<ContentTranslate> removeContentTranslate( @PathVariable Long id){
        ContentTranslateService.deleteContentTranslate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
