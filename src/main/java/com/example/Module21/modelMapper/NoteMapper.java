package com.example.Module21.modelMapper;

import com.example.Module21.dto.NoteCreateDto;
import com.example.Module21.dto.NoteDto;
import com.example.Module21.model.Note;


public class NoteMapper {
    public static NoteDto toDto(Note note) {
        return new NoteDto(
                note.getId(),
                note.getDate(),
                note.getText(),
                note.isDone()
        );
    }


    public static Note toEntity(NoteCreateDto dto) {
        Note note = new Note();
        note.setText(dto.getText());
        note.setDone(dto.isDone());
        note.setDate(dto.getDate());
        return note;
    }

    public static Note toEntity(NoteDto dto) {
        Note note = new Note();
        note.setId(dto.getId());
        note.setText(dto.getText());
        note.setDone(dto.isDone());
        note.setDate(dto.getDate());
        return note;
    }
}
