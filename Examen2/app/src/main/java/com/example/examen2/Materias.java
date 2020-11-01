package com.example.examen2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Constants.TABLE_NAME_MATERIAS)
public class Materias {

    @PrimaryKey(autoGenerate = true)
    private Long ID;
    private String strMateria;
    private String strHorario;
    private String strDia;

    public Materias(String strMateria, String strHorario, String strDia) {
        this.strMateria = strMateria;
        this.strHorario = strHorario;
        this.strDia = strDia;
    }

    public String getStrMateria() { return strMateria; }

    public void setStrMateria(String strMateria) { this.strMateria = strMateria; }

    public String getStrHorario() { return strHorario; }

    public void setStrHorario(String strHorario) { this.strHorario = strHorario; }

    public String getStrDia() { return strDia; }

    public void setStrDia(String strDia) { this.strDia = strDia; }

    public Long getID() { return ID; }

    public void setID(Long ID) { this.ID = ID; }
}
