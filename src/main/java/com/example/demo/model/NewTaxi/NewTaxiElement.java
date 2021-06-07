package com.example.demo.model.NewTaxi;

public interface NewTaxiElement {
    public NewTaxiElement clone();
    public String toHTML();
    public int compareTo(NewTaxiElement elem);
}
