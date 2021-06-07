package com.example.demo.model.NewTaxiForms;

import com.example.demo.model.NewTaxi.DBDoced;
import com.example.demo.model.NewTaxi.NewTaxiElement;
import com.example.demo.model.NewTaxi.TaxiDriver;
import com.example.demo.model.NewTaxi.TaxiEmployee;
import org.bson.Document;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiDriver
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|20:37
 * @Version TaxiDriver: 1.0
 */
public class TaxiDriverForm implements FormatClass{
    public String full_name;
    public String rating;
    public String work_hours_day;
    public String work_hours_night;
    public String premium;
    public String driver_id;
    public String car_id;

    public TaxiDriverForm() {
    }

    public TaxiDriverForm(String full_name, String rating, String work_hours_day, String work_hours_night, String premium, String driver_id, String car_id) {
        this.full_name = full_name;
        this.rating = rating;
        this.work_hours_day = work_hours_day;
        this.work_hours_night = work_hours_night;
        this.premium = premium;
        this.driver_id = driver_id;
        this.car_id = car_id;
    }
    public TaxiDriverForm(TaxiDriver elem) {
        this.full_name = elem.full_name;
        this.rating = String.valueOf(elem.rating);
        this.work_hours_day = String.valueOf(elem.work_hours_day);
        this.work_hours_night = String.valueOf(elem.work_hours_night);
        this.premium = String.valueOf(elem.premium);
        this.driver_id = String.valueOf(elem.driver_id);
        this.car_id = String.valueOf(elem.car_id);
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getWork_hours_day() {
        return work_hours_day;
    }

    public void setWork_hours_day(String work_hours_day) {
        this.work_hours_day = work_hours_day;
    }

    public String getWork_hours_night() {
        return work_hours_night;
    }

    public void setWork_hours_night(String work_hours_night) {
        this.work_hours_night = work_hours_night;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }
}
