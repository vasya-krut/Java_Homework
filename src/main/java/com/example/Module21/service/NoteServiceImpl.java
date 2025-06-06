package com.example.Module21.service;

import com.example.Module21.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Module21.repository.NoteJpaRepository;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    final private NoteJpaRepository noteJpaRepository;

    public NoteServiceImpl(NoteJpaRepository noteJpaRepository) {
        this.noteJpaRepository = noteJpaRepository;
    }

    @Override
    public void createNote(Note note) {
        noteJpaRepository.save(note);
    }

    @Override
    public String deleteNote(long id) {
        String otvet;
        if(noteJpaRepository.existsById(id))
            otvet = "Заметка успешно удалена";
        else
            otvet = "Заметки с таким идентификатором нет";
        noteJpaRepository.deleteById(id);
        return otvet;
    }

    @Override
    public String updateNote(Note note) {
        String otvet;
        if(noteJpaRepository.existsById(note.getId()))
        {
            otvet = "Заметка успешно обновлена";
            noteJpaRepository.save(note);
        }
        else
            otvet = "Заметки с таким идентификатором нет";
        return otvet;
    }

    @Override
    public List<Note> showAllNotes() {
        return noteJpaRepository.findAll();
    }
}
