package com.example.Module21.dto;
import java.util.Date;

public class NoteDto {


    private long id;
    private Date date;//дата, когда нужно выполнить действие в тексте
    private String text;
    private boolean done;

    public NoteDto() {
        super();
    }

    public NoteDto(long id, Date date, String text, boolean done) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
