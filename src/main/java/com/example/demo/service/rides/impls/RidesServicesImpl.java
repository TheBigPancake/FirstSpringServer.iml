package com.example.demo.service.rides.impls;

import com.example.demo.data.DataBase;
import com.example.demo.data.FakeData;
import com.example.demo.data.MongoDataBase;
import com.example.demo.model.NewTaxi.DBTaxiTables;
import com.example.demo.model.NewTaxi.TaxiRide;
import com.example.demo.model.NewTaxi.TaxiRide;
import com.example.demo.service.ModelService;
import org.springframework.stereotype.Repository;

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
public class RidesServicesImpl implements ModelService<TaxiRide> {
    private DataBase db = new MongoDataBase();
    @Override
    public TaxiRide getByIDOrNull(int id) {
        var list = db.getAll(DBTaxiTables.Rides);
        for (var item: list)
            if(((TaxiRide)item).ride_id == id)
                return (TaxiRide)item;
        return null;
    }
    @Override
    public void insert(TaxiRide elem) {
        db.insert(elem,DBTaxiTables.Rides);
    }
    @Override
    public boolean update(TaxiRide elem) {
        return db.update(elem,DBTaxiTables.Rides);
    }
    @Override
    public boolean delete(TaxiRide elem) {
        return db.delete(elem, DBTaxiTables.Rides);
    }
    @Override
    public List<TaxiRide> getList() {
        var list = new ArrayList<TaxiRide>();
        for (var item: db.getAll(DBTaxiTables.Rides)) {
            list.add((TaxiRide) item);
        }
        return list;
    }
}
