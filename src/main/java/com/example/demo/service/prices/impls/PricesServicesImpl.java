package com.example.demo.service.prices.impls;

import com.example.demo.data.DataBase;
import com.example.demo.data.FakeData;
import com.example.demo.data.MongoDataBase;
import com.example.demo.model.NewTaxi.*;
import com.example.demo.model.NewTaxi.TripPrices;
import com.example.demo.model.NewTaxi.TripPrices;
import com.example.demo.service.ModelService;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.CustomerServicesImpl
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|23:44
 * @Version CustomerServicesImpl: 1.0
 */
@Repository
public class PricesServicesImpl  {
    private DataBase db = new MongoDataBase();

    public TripPrices  getPriceOrNull(LocalDateTime date, CarType type) {
        var list = db.getAll(DBTaxiTables.Prices );
        for (var item: list)
            if(((TripPrices )item).car_type == type && ((TripPrices )item).date.equals(date))
                return (TripPrices )item;
        return null;
    }

    public void insert(TripPrices  elem) {
        db.insert(elem,DBTaxiTables.Prices );
    }

    public boolean update(TripPrices  elem) {
        return db.update(elem,DBTaxiTables.Prices );
    }

    public boolean delete(TripPrices  elem) {
        return db.delete(elem, DBTaxiTables.Prices );
    }

    public List<TripPrices > getList() {
        var list = new ArrayList<TripPrices >();
        for (var item: db.getAll(DBTaxiTables.Prices )) {
            list.add((TripPrices ) item);
        }
        return list;
    }
}
