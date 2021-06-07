package com.example.demo.service.operator.impls;

import com.example.demo.data.DataBase;
import com.example.demo.data.FakeData;
import com.example.demo.data.MongoDataBase;
import com.example.demo.model.NewTaxi.Customer;
import com.example.demo.model.NewTaxi.DBTaxiTables;
import com.example.demo.model.NewTaxi.TaxiOperator;
import com.example.demo.model.NewTaxi.TaxiOperator;
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
public class OperatorServicesImpl implements ModelService<TaxiOperator> {
    private DataBase db = new MongoDataBase();
    @Override
    public TaxiOperator getByIDOrNull(int id) {
        var list = db.getAll(DBTaxiTables.Operators);
        for (var item: list)
            if(((TaxiOperator)item).operator_id == id)
                return (TaxiOperator)item;
        return null;
    }
    @Override
    public void insert(TaxiOperator elem) {
        db.insert(elem,DBTaxiTables.Operators);
    }
    @Override
    public boolean update(TaxiOperator elem) {
        return db.update(elem,DBTaxiTables.Operators);
    }
    @Override
    public boolean delete(TaxiOperator elem) {
        return db.delete(elem, DBTaxiTables.Operators);
    }
    @Override
    public List<TaxiOperator> getList() {
        var list = new ArrayList<TaxiOperator>();
        for (var item: db.getAll(DBTaxiTables.Operators)) {
            list.add((TaxiOperator) item);
        }
        return list;
    }
}
