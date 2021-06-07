package com.example.demo.data;

import com.example.demo.model.NewTaxi.*;

import java.util.List;

public interface DataBase {
    public List<NewTaxiElement> getAll(DBTaxiTables table);

    public boolean insert(NewTaxiElement elem, DBTaxiTables table);
    public boolean update(NewTaxiElement elem, DBTaxiTables table);

    public boolean delete(NewTaxiElement elem, DBTaxiTables table);


}
