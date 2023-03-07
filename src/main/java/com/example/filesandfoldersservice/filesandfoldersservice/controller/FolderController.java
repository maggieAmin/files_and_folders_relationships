package com.example.filesandfoldersservice.filesandfoldersservice.controller;

import com.example.filesandfoldersservice.filesandfoldersservice.models.Folder;
import com.example.filesandfoldersservice.filesandfoldersservice.models.Person;
import com.example.filesandfoldersservice.filesandfoldersservice.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id) {
        Optional<Folder> optionalFolder = folderRepository.findById(id);

        if (optionalFolder.isPresent()) {
            return new ResponseEntity<>(optionalFolder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optionalFolder, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

}
