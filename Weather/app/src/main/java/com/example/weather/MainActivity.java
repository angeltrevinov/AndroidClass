package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ClimaAdapter climaAdapter;
    private List<Clima> climaList;
    private RequestQueue requestQueue;

    private TextView txtactual;
    private TextView txt_clima_descripcion;
    private TextView txt_nombreubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtactual = findViewById(R.id.txt_clima_actual);
        txt_clima_descripcion = findViewById(R.id.txt_clima_descripcion);
        txt_nombreubicacion = findViewById(R.id.txt_nombreUbicacion);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestView = Volley.newRequestQueue(this);
    }

    private void parseClimaActual() {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Monterrey,Mx&appid=aea208a58f22c7fe32632fe1c466f147&units=metric&lang=es";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject temp_actual = response.getJSONObject("main");
                            Integer actual = (int)Float.parseFloat((temp_actual.getString("temp")));

                        }catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);
    }
}