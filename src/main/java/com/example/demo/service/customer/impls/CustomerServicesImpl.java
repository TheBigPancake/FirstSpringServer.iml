package com.example.demo.service.customer.impls;

import com.example.demo.data.DataBase;
import com.example.demo.data.FakeData;
import com.example.demo.data.MongoDataBase;
import com.example.demo.model.NewTaxi.Customer;
import com.example.demo.model.NewTaxi.DBTaxiTables;
import com.example.demo.model.NewTaxi.Customer;
import com.example.demo.service.ModelService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
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
public class CustomerServicesImpl implements ModelService<Customer> {
    private DataBase db = new MongoDataBase();
    //private DataBase db = new FakeData();
    @Override
    public Customer getByIDOrNull(int id) {
        var list = db.getAll(DBTaxiTables.Customers);
        for (var item: list)
            if(((Customer)item).customer_id == id)
                return (Customer)item;
        return null;
    }
    @Override
    public void insert(Customer elem) {
        db.insert(elem,DBTaxiTables.Customers);
    }
    @Override
    public boolean update(Customer elem) {
        return db.update(elem,DBTaxiTables.Customers);
    }
    @Override
    public boolean delete(Customer elem) {
        return db.delete(elem, DBTaxiTables.Customers);
    }
    @Override
    public List<Customer> getList() {
        var list = new ArrayList<Customer>();
        for (var item: db.getAll(DBTaxiTables.Customers))
            list.add((Customer) item);
        return list;
    }
}
