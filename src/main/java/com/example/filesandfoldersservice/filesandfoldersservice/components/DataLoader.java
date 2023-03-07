package com.example.filesandfoldersservice.filesandfoldersservice.components;

import com.example.filesandfoldersservice.filesandfoldersservice.models.File;
import com.example.filesandfoldersservice.filesandfoldersservice.models.Folder;
import com.example.filesandfoldersservice.filesandfoldersservice.models.Person;
import com.example.filesandfoldersservice.filesandfoldersservice.repository.FileRepository;
import com.example.filesandfoldersservice.filesandfoldersservice.repository.FolderRepository;
import com.example.filesandfoldersservice.filesandfoldersservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Person maggie = new Person("Maggie");
        personRepository.save(maggie);

        Person marc = new Person("Marc");
        personRepository.save(marc);

        Person david = new Person("David");
        personRepository.save(david);

        Folder java = new Folder("Java folder", maggie);
        folderRepository.save(java);

        Folder ruby = new Folder("Ruby folder", marc);
        folderRepository.save(ruby);

        Folder python = new Folder("Python folder", david);
        folderRepository.save(python);

        File relationship = new File("Relationship", "sql", 5, java);
        fileRepository.save(relationship);

        File classes = new File("Classes", "cla", 9, ruby);
        fileRepository.save(classes);

        File testing = new File("Testing", "tdd", 4, python);
        fileRepository.save(testing);

        List<Person> persons = personRepository.findAll();
        System.out.println(persons);
    }
}
