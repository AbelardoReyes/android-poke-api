package com.example.pokeapi;

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

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.MyViewHolder> {
    public final ArrayList<Pokemon> PokemonList;

    public PokemonAdapter(ArrayList<Pokemon> pokemonList) {
        PokemonList = pokemonList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_pokemon,parent,false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String id = PokemonList.get(position).getUrl().substring(34, PokemonList.get(position).getUrl().length() - 1);
        String name = PokemonList.get(position).getName();
        String url = PokemonList.get(position).getUrl();
        holder.name.setText(name);
        holder.url.setText(url);
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+id+".png")
                .into(holder.imgPokemon);
    }

    @Override
    public int getItemCount() {
        return PokemonList.size();
    }

    //ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView url;
        ImageView imgPokemon;

        public MyViewHolder(final View view) {
            super(view);
            name = view.findViewById(R.id.name);
            url = view.findViewById(R.id.url);
            imgPokemon = view.findViewById(R.id.imageView2);
        }

        private void setData(Pokemon pk) {

        }
    }
    //Adaptador

}
