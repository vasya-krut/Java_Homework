package com.example.Module21.repository;

import com.example.Module21.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface NoteJpaRepository extends JpaRepository<Note, Long> {


}
