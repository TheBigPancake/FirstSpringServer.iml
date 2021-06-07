package com.example.demo.service.driver.impls;

import com.example.demo.data.DataBase;
import com.example.demo.data.FakeData;
import com.example.demo.data.MongoDataBase;
import com.example.demo.model.NewTaxi.TaxiDriver;
import com.example.demo.model.NewTaxi.DBTaxiTables;
import com.example.demo.model.NewTaxi.TaxiDriver;
import com.example.demo.service.ModelService;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.TaxiDriverServicesImpl
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|23:44
 * @Version TaxiDriverServicesImpl: 1.0
 */
public class DriverServicesImpl implements ModelService<TaxiDriver> {
    private DataBase db = new MongoDataBase();
    @Override
    public TaxiDriver getByIDOrNull(int id) {
        var list = db.getAll(DBTaxiTables.Drivers);
        for (var item: list)
            if(((TaxiDriver)item).driver_id == id)
                return (TaxiDriver)item;
        return null;
    }
    @Override
    public void insert(TaxiDriver elem) {
        db.insert(elem,DBTaxiTables.Drivers);
    }
    @Override
    public boolean update(TaxiDriver elem) {
        return db.update(elem,DBTaxiTables.Drivers);
    }
    @Override
    public boolean delete(TaxiDriver elem) {
        return db.delete(elem, DBTaxiTables.Drivers);
    }
    @Override
    public List<TaxiDriver> getList() {
        var list = new ArrayList<TaxiDriver>();
        for (var item: db.getAll(DBTaxiTables.Drivers)) {
            list.add((TaxiDriver) item);
        }
        return list;
    }
}
