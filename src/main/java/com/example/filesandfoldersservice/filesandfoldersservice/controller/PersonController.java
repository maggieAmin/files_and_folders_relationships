package com.example.filesandfoldersservice.filesandfoldersservice.controller;

import com.example.filesandfoldersservice.filesandfoldersservice.models.Person;
import com.example.filesandfoldersservice.filesandfoldersservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isPresent()) {
            return new ResponseEntity<>(optionalPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optionalPerson, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> postPerson(@RequestBody Person person){
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }




}
