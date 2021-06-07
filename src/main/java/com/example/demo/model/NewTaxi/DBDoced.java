package com.example.demo.model.NewTaxi;

import org.bson.Document;

public interface DBDoced extends NewTaxiElement {
    static public Object Create(Document doc){return null;}
    public Document getDoc();
    public Document setKey();
}
