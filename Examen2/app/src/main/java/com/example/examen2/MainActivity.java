package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public Adapter mAdapter;
    private List<Materias> mMateriasList = new ArrayList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /* Inicia código de Fragment  */
        dynamicFragment fragment = new dynamicFragment();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.dynamicFragment, fragment);
        fragmentTransaction.commit();

        /*   Recycler View           */
        this.mRecyclerView = findViewById(R.id.RecyclerView);

        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        this.generateMaterias();

        this.mAdapter = new Adapter(this, this.mMateriasList);

        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    // -------------------------------------------------
    public void generateMaterias() {
        this.mMateriasList.add(new Materias(
                "Android",
                "6 a 9pm",
                "Martes"
        ));
        this.mMateriasList.add(new Materias(
                "Seguridad Avanzada",
                "2:30pm a 4pm",
                "Lunes y Jueves"
        ));
        this.mMateriasList.add(new Materias(
                "Lenguajes de Programación",
                "4pm a 5:30pm",
                "Martes y Viernes"
        ));
    }
}