package com.example.demo.model.NewTaxiForms;

import com.example.demo.model.NewTaxi.CarType;
import com.example.demo.model.NewTaxi.DBDoced;
import com.example.demo.model.NewTaxi.NewTaxiElement;
import com.example.demo.model.NewTaxi.TaxiCar;
import org.bson.Document;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiCar
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|20:36
 * @Version TaxiCar: 1.0
 */
public class TaxiCarForm implements FormatClass{
    public String car_id;
    public String description;
    public String type;

    public TaxiCarForm() {
    }

    public TaxiCarForm(String car_id, String description, String type) {
        this.car_id = car_id;
        this.description = description;
        this.type = type;
    }
    public TaxiCarForm(TaxiCar elem) {
        this.car_id = String.valueOf(elem.car_id);
        this.description = elem.description;
        this.type = elem.type.toString();
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
