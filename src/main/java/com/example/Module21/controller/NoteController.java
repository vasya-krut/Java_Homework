package com.example.Module21.controller;

import com.example.Module21.model.Note;
import com.example.Module21.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notepad")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> saveNote(@RequestBody Note note) {
        noteService.createNote(note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> showAllNotes() {
        return new ResponseEntity<>(noteService.showAllNotes(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateNotes(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.updateNote(note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable long id)
    {
        return new ResponseEntity<>(noteService.deleteNote(id), HttpStatus.OK);
    }
}
