package com.example.filesandfoldersservice.filesandfoldersservice.repository;

import com.example.filesandfoldersservice.filesandfoldersservice.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
