package com.example.demo.service.orders.impls;

import com.example.demo.data.DataBase;
import com.example.demo.data.FakeData;
import com.example.demo.data.MongoDataBase;
import com.example.demo.model.NewTaxi.DBTaxiTables;
import com.example.demo.model.NewTaxi.TaxiOrder;
import com.example.demo.model.NewTaxi.TaxiOrder;
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
public class OrdersServicesImpl implements ModelService<TaxiOrder> {
    private DataBase db = new MongoDataBase();
    @Override
    public TaxiOrder getByIDOrNull(int id) {
        var list = db.getAll(DBTaxiTables.Orders);
        for (var item: list)
            if(((TaxiOrder)item).order_id == id)
                return (TaxiOrder)item;
        return null;
    }
    @Override
    public void insert(TaxiOrder elem) {
        db.insert(elem,DBTaxiTables.Orders);
    }
    @Override
    public boolean update(TaxiOrder elem) {
        return db.update(elem,DBTaxiTables.Orders);
    }
    @Override
    public boolean delete(TaxiOrder elem) {
        return db.delete(elem, DBTaxiTables.Orders);
    }
    @Override
    public List<TaxiOrder> getList() {
        var list = new ArrayList<TaxiOrder>();
        for (var item: db.getAll(DBTaxiTables.Orders)) {
            list.add((TaxiOrder) item);
        }
        return list;
    }
}
