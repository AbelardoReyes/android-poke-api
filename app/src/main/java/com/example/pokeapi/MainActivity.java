package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Pokemon> PokemonList;
    RecyclerView recyclerView;
    int Cont=20;
    ImageView imgPokemon,text3;
    JsonObjectRequest pedirpokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        imgPokemon = findViewById(R.id.imageView2);
        text3 = findViewById(R.id.text3);
        PokemonList = new ArrayList<>();
        ConsumeAPI();
    }
    private void setAdapter(PokemonAdapter adapter){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void Lista(){

    }
    private void ConsumeAPI(){
        String Url = "https://pokeapi.co/api/v2/pokemon?offset=0&limit=200";
        pedirpokemon = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                Respuesta pk = gson.fromJson(String.valueOf(response),Respuesta.class);
                List<Pokemon> results = pk.getResults();
                PokemonAdapter adapter = new PokemonAdapter((ArrayList<Pokemon>) results);
                setAdapter(adapter);
                Log.i("Res",response.toString());
                String img = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png";
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Res",error.toString());
            }
        });
        SingletonRequest.getInstance(this).addToRequestQue(pedirpokemon);
    }

    @Override
    public void onClick(View view) {

    }
}