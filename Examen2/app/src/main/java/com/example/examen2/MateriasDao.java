package com.example.examen2;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;

public interface MateriasDao {

    @Query("SELECT * FROM " + Constants.TABLE_NAME_MATERIAS)
    ArrayList<Materias>getMaterias();

    @Query("DELETE FROM " + Constants.TABLE_NAME_MATERIAS)
    void deleteMaterias();

    @Insert
    long insertMateria(Materias materias);
}
