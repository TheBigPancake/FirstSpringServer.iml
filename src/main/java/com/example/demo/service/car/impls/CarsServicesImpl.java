package com.example.demo.service.car.impls;

import com.example.demo.data.DataBase;
import com.example.demo.data.MongoDataBase;
import com.example.demo.model.NewTaxi.CarType;
import com.example.demo.model.NewTaxi.DBTaxiTables;
import com.example.demo.model.NewTaxi.TaxiCar;
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
public class CarsServicesImpl implements ModelService<TaxiCar> {
    private DataBase db = new MongoDataBase();
    @Override
    public TaxiCar getByIDOrNull(int id) {
        var list = db.getAll(DBTaxiTables.Cars);
        for (var item: list)
            if(((TaxiCar)item).car_id == id)
                return (TaxiCar)item;
            return null;
    }
    @Override
    public void insert(TaxiCar elem) {
        db.insert(elem,DBTaxiTables.Cars);
    }
    @Override
    public boolean update(TaxiCar elem) {
        return db.update(elem,DBTaxiTables.Cars);
    }
    @Override
    public boolean delete(TaxiCar elem) {
        return db.delete(elem, DBTaxiTables.Cars);
    }
    @Override
    public List<TaxiCar> getList() {
        var list = new ArrayList<TaxiCar>();
        for (var item: db.getAll(DBTaxiTables.Cars)) {
            list.add((TaxiCar) item);
        }
        return list;
    }
}
