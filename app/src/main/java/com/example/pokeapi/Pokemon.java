package com.example.pokeapi;

import android.widget.ImageView;

public class Pokemon {
    String name, url;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
