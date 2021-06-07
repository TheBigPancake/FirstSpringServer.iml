package com.example.demo.data;

import com.example.demo.model.NewTaxi.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.FakeData
 *
 * @Autor: golde
 * @DateTime: 30.03.2021|18:10
 * @Version FakeData: 1.0
 */
public class FakeData implements DataBase {
    public FakeData()
    {
    }
    private static List<NewTaxiElement> drivers = new ArrayList<>(
            Arrays.asList(
                    new TaxiDriver("Da Po Za", 1,1),
                    new TaxiDriver("Ga Ro Ya", 2,2),
                    new TaxiDriver("Fa Ta Ha", 3,3),
                    new TaxiDriver("Da Ro Ga", 4,4)
            )
    );
    private static List<NewTaxiElement> customers = new ArrayList<>(
            Arrays.asList(
                    new Customer(1,"Da Ao Za", "001", false),
                    new Customer(2,"Fa Do Fa", "002", false),
                    new Customer(3,"Ga Po Ra", "003", true),
                    new Customer(4,"Da Lo Ba", "004", false),
                    new Customer(5,"Ra Ko Na", "005", false),
                    new Customer(6,"Ta Jo Ma", "006", false),
                    new Customer(7,"Ya Uo Sa", "007", false)
            )
    );
    private static List<NewTaxiElement> operators = new ArrayList<>(
            Arrays.asList(
                    new TaxiOperator("Da Po Za", 1),
                    new TaxiOperator("Ga Ro Ya", 2),
                    new TaxiOperator("Fa Ta Ha", 3),
                    new TaxiOperator("Da Ro Ga", 4)
            )
    );
    private static List<NewTaxiElement> cars = new ArrayList<>(
            Arrays.asList(
                    new TaxiCar(1, "", CarType.bisnes),
                    new TaxiCar(2, "",CarType.microbus),
                    new TaxiCar(3, "",CarType.premium),
                    new TaxiCar(4, "",CarType.standart)
            )
    );
    private static List<NewTaxiElement> orders = new ArrayList<>(
            Arrays.asList(
                    TaxiOrder.CreateOrder(1,1,"001","dasd1", "dadsa1", CarType.bisnes),
                    TaxiOrder.CreateOrder(2,2,"002","dasd2", "dadsa2",CarType.microbus),
                    TaxiOrder.CreateOrder(3,3,"003","dasd3", "dadsa3",CarType.premium),
                    TaxiOrder.CreateOrder(4,4,"004","dasd4", "dadsa4",CarType.standart)
            )
    );
    private static List<NewTaxiElement> rides = new ArrayList<>(
            Arrays.asList(
                    TaxiRide.startRide(1, 1,1),
                    TaxiRide.startRide(2, 2,2),
                    TaxiRide.startRide(3, 3,3),
                    TaxiRide.startRide(4, 4,4)
            )
    );
    private static List<NewTaxiElement> prices = new ArrayList<>(
            Arrays.asList(
                    new TripPrices(CarType.bisnes, 40,14, 124, 144),
                    new TripPrices(CarType.microbus, 60,22, 166, 188),
                    new TripPrices(CarType.premium, 120,66, 299, 349),
                    new TripPrices(CarType.standart, 30,14, 109, 159)
            )
    );
    @Override
    public List<NewTaxiElement> getAll(DBTaxiTables table) {
        try {
            var list = new ArrayList<NewTaxiElement>();
            var collection = getCollection(table);
            for (var item : collection)
                list.add(item.clone());
            return list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public boolean insert(NewTaxiElement elem, DBTaxiTables table) {
        try {
            var collection = getCollection(table);
            for (var item : collection)
                if(item.compareTo(elem)==0)
                    return false;
            collection.add(elem);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(NewTaxiElement elem, DBTaxiTables table) {
        try {
            var collection = getCollection(table);
            for (var item : collection)
                if(item.compareTo(elem)==0)
                {
                    collection.remove(item);
                    collection.add(elem);
                    break;
                }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(NewTaxiElement elem, DBTaxiTables table) {
        try {
            var collection = getCollection(table);
            for (var item : collection)
                if(item.compareTo(elem)==0)
                {
                    collection.remove(item);
                    break;
                }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private List<NewTaxiElement> getCollection(DBTaxiTables table) throws Exception {
        switch (table) {
            case Customers:
                return customers;
            case Operators:
                return operators;
            case Drivers:
                return drivers;
            case Prices:
                return prices;
            case Orders:
                return orders;
            case Rides:
                return rides;
            case Cars:
                return cars;
        }
        throw new Exception("TABLE NAME ERROR");
    }
}
