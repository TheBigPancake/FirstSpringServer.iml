package com.example.demo.data;

import com.example.demo.model.NewTaxi.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.MongoDataBase
 *
 * @Autor: golde
 * @DateTime: 06.04.2021|10:04
 * @Version MongoDataBase: 1.0
 */

@Service
public class MongoDataBaseByTemplate implements DataBase {
    private final String db_name = "NewTaxiDB";
    private final String customers_col_name = "Customers";
    private final String cars_col_name = "TaxiCars";
    private final String drivers_col_name = "TaxiDrivers";
    private final String operators_col_name = "TaxiOperators";
    private final String prices_col_name = "TaxiPrices";
    private final String orders_col_name = "TaxiOrders";
    private final String rides_col_name = "TaxiRide";
    private MongoClient mongo_client;
    public MongoDataBaseByTemplate()
    {
        mongo_client = MongoClients.create();
    }
    @Override
    public List<NewTaxiElement> getAll(DBTaxiTables table) {
        try {
            var collection = getCollectionArray(table);
            List<NewTaxiElement> items = new ArrayList<>();
            for (Document item : collection)
                addToItems(table, items, item);
            return items;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void addToItems(DBTaxiTables table, List<NewTaxiElement> items, Document item) {
        switch (table) {
            case Customers:
                items.add((NewTaxiElement)Customer.Create(item));
                break;
            case Rides:
                items.add((NewTaxiElement)TaxiRide.Create(item));
                break;
            case Orders:
                items.add((NewTaxiElement)TaxiOrder.Create(item));
                break;
            case Prices:
                items.add((NewTaxiElement)TripPrices.Create(item));
                break;
            case Drivers:
                items.add((NewTaxiElement)TaxiDriver.Create(item));
                break;
            case Operators:
                items.add((NewTaxiElement)TaxiOperator.Create(item));
                break;
            case Cars:
                items.add((NewTaxiElement)TaxiCar.Create(item));
                break;
        }
    }

    @Override
    public boolean insert(NewTaxiElement elem, DBTaxiTables table) {
        try {
            var collection = getCollection(table);
            Document ins = ((DBDoced)elem).getDoc();
            collection.insertOne(ins);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(NewTaxiElement elem, DBTaxiTables table) {
        try {
            var collection = getCollection(table);
            Document query = ((DBDoced)elem).setKey();
            Document upd = ((DBDoced)elem).getDoc();
            collection.updateOne(query, upd);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(NewTaxiElement elem, DBTaxiTables table) {
        try {
            var collection = getCollection(table);
            Document del = ((DBDoced)elem).getDoc();
            collection.deleteOne(del);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @NotNull
    private ArrayList<Document> getCollectionArray(DBTaxiTables table) throws Exception {
        return mongo_client
                .getDatabase(db_name)
                .getCollection(getColName(table)).find().into(new ArrayList<>());
    }

    @NotNull
    private MongoCollection<Document> getCollection(DBTaxiTables table) throws Exception {
        return mongo_client
                .getDatabase(db_name)
                .getCollection(getColName(table));
    }

    private String getColName(DBTaxiTables table) throws Exception {
        switch (table) {
            case Customers:
                return customers_col_name;
            case Operators:
                return operators_col_name;
            case Drivers:
                return drivers_col_name;
            case Prices:
                return prices_col_name;
            case Orders:
                return orders_col_name;
            case Rides:
                return rides_col_name;
            case Cars:
                return cars_col_name;
        }
        throw new Exception("TABLE NAME ERROR");
    }
}