package com.example.notesdb.notesdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = Constants.TABLE_NAME_NOTES)
public class Note {

    @PrimaryKey(autoGenerate = false)
    private long ID;
    private String strNote;
    private Date date;

    public Note(String strNote, Date date) {
        this.strNote = strNote;
        this.date = date;
        this.ID = 1;
    }

    public long getID() { return ID; }

    public void setID(long ID) { this.ID = ID; }

    public String getStrNote() { return strNote; }

    public void setStrNote(String strNote) { this.strNote = strNote; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }
}
