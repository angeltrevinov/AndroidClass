package com.example.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ClimaAdapter extends RecyclerView.Adapter<ClimaAdapter.ViewHolder> {

    private Context mContext;
    private List<Clima> mClimaList;

    public ClimaAdapter(Context context, List<Clima> climaList) {
        mContext = context;
        mClimaList = climaList;
    }

    @NonNull
    @Override
    public ClimaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClimaAdapter.ViewHolder holder, int position) {
        Clima currentItem = mClimaList.get(position);
        String climaUrl = currentItem.getClimaUrl();
        String forecastDia = currentItem.getForecastDia();
        String forecastDescription = currentItem.getForecastDescription();
        String forecastMinMax = currentItem.getForecastMinMax();

        holder.ForecastDia.setText(forecastDia);
        holder.ForecastDescription.setText(forecastDescription);
        holder.ForecastMinMax.setText(forecastMinMax);
        Picasso.with(mContext).load(climaUrl).fit().centerInside().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mClimaList.size();
    }

    // Realiza el binding de los objetos
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView ForecastDia;
        public TextView ForecastDescription;
        public TextView ForecastMinMax;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            ForecastDia = itemView.findViewById(R.id.txt_forecastDia);
            ForecastDescription = itemView.findViewById(R.id.txt_forecastDescripcion);
            ForecastMinMax = itemView.findViewById(R.id.txt_forecastMinMax);
        }
    }
}
