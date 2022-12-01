package com.example.pokeapi;

import java.util.ArrayList;
import java.util.List;

public class Respuesta {
    String count, next, previous;
    List<Pokemon> results;

    public Respuesta(String count, String next, String previous, List<Pokemon> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
