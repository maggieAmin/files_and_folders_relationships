package com.example.filesandfoldersservice.filesandfoldersservice.repository;

import com.example.filesandfoldersservice.filesandfoldersservice.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
