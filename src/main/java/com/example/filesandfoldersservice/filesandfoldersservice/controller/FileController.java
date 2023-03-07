package com.example.filesandfoldersservice.filesandfoldersservice.controller;

import com.example.filesandfoldersservice.filesandfoldersservice.models.File;
import com.example.filesandfoldersservice.filesandfoldersservice.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles() {
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id) {
        Optional<File> optionalFile = fileRepository.findById(id);

        if (optionalFile.isPresent()) {
            return new ResponseEntity<>(optionalFile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optionalFile, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postFolder(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

}
