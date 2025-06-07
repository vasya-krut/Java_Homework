package com.example.Module21.controller;

import com.example.Module21.dto.NoteCreateDto;
import com.example.Module21.dto.NoteDto;
import com.example.Module21.model.Note;
import com.example.Module21.modelMapper.NoteMapper;
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
    public ResponseEntity<NoteDto> saveNote(@RequestBody NoteCreateDto noteCreateDto) {
        Note note = NoteMapper.toEntity(noteCreateDto);
        noteService.createNote(note);
        return new ResponseEntity<>(NoteMapper.toDto(note), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> showAllNotes() {
        return new ResponseEntity<>(noteService.showAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNote(@PathVariable long id) {
        Note note = noteService.getById(id);
        if(note.getId() != -1)
            return ResponseEntity.ok(NoteMapper.toDto(note));
        return ResponseEntity.ok("Заметки с таким идентификатором нет");
    }

    @PutMapping
    public ResponseEntity<String> updateNotes(@RequestBody NoteDto noteDto) {
        Note note = NoteMapper.toEntity(noteDto);
        return ResponseEntity.ok(noteService.updateNote(note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable long id)
    {
        return new ResponseEntity<>(noteService.deleteNote(id), HttpStatus.OK);
    }
}
