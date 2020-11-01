package com.example.examen2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private Context mContexT;
    private List<Materias> mMateriasList;

    public Adapter(Context mContexT, List<Materias> mMateriasList) {
        this.mContexT = mContexT;
        this.mMateriasList = mMateriasList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContexT).inflate(R.layout.materiacard,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        final Materias currentMateria = this.mMateriasList.get(position);

        holder.tvMateria.setText(currentMateria.getStrMateria());
        holder.tvHorario.setText(currentMateria.getStrHorario());
        holder.tvDia.setText(currentMateria.getStrDia());
    }

    @Override
    public int getItemCount() { return this.mMateriasList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView tvMateria;
       TextView tvHorario;
       TextView tvDia;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvMateria = itemView.findViewById(R.id.textView_materia);
            this.tvHorario = itemView.findViewById(R.id.textView_horario);
            this.tvDia = itemView.findViewById(R.id.textView_dia);

        }
    }
}
