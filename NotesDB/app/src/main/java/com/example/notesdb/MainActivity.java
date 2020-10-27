package com.example.notesdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notesdb.notesdb.Note;
import com.example.notesdb.notesdb.NoteDatabase;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    TextView tvFecha;
    Note note;

    private NoteDatabase noteDatabase;
    private Boolean newNote;

    // -----------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etNote = findViewById(R.id.etNote);
        this.tvFecha = findViewById(R.id.tvFecha);
        this.noteDatabase = NoteDatabase.getInstance(this);
        this.getNote();
    }

    // -----------------------------------------------------
    public void saveNote(View view) {
        String strMessage = this.etNote.getText().toString();
        Date date = new Date(System.currentTimeMillis());
        if (this.newNote) {
            this.note = new Note(strMessage, date);
            long j = this.noteDatabase.getNoteDao().insertNote(this.note);
            this.showToast("saved note with id: " + j);
        } else {
            this.note.setStrNote(strMessage);
            this.note.setDate(date);
            this.noteDatabase.getNoteDao().updateNote(this.note);
            this.showToast("Note update");
        }
        this.getNote();
    }

    // -----------------------------------------------------
    public void deleteNote(View view) {
        if(!this.newNote) {
            this.noteDatabase.getNoteDao().deleteNote(this.note);
            this.showToast("Note Deleted!");
        }

        this.newNote = true;

        this.etNote.setText("");
        this.tvFecha.setText("");
    }

    // -----------------------------------------------------
    public void getNote() {
        this.note = noteDatabase.getNoteDao().getNote();

        if (this.note != null) {
            etNote.setText(String.valueOf(this.note.getStrNote()));
            tvFecha.setText(String.valueOf(this.note.getDate()));
            this.newNote = false;
        } else {
            this.newNote = true;
        }
    }

    // -----------------------------------------------------
    public void showToast(String strMessage) {
        Toast toast = Toast.makeText(this, strMessage, Toast.LENGTH_SHORT);
        toast.show();
    }
}