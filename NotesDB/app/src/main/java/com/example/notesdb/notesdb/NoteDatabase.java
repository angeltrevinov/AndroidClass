package com.example.notesdb.notesdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Note.class}, version = 1)
@TypeConverters({DataRoomConverter.class})
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao getNoteDao();

    private static NoteDatabase INSTANCE;

    public static synchronized NoteDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabaseInstanceContext(context);
        }
        return INSTANCE;
    }

    public static NoteDatabase buildDatabaseInstanceContext(Context context) {
        return Room.databaseBuilder(
                context,
                NoteDatabase.class,
                Constants.DB_NAME
        ).allowMainThreadQueries().build();
    }

}
