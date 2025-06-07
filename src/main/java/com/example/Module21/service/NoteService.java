package com.example.Module21.service;

import com.example.Module21.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    void createNote(Note note);
    String deleteNote(long id);
    String updateNote(Note note);
    List<Note> showAllNotes();
    public Note getById(long id);
}
