package com.example.demo.model.NewTaxiForms;

import com.example.demo.model.NewTaxi.CarType;
import com.example.demo.model.NewTaxi.DBDoced;
import com.example.demo.model.NewTaxi.NewTaxiElement;
import com.example.demo.model.NewTaxi.TripPrices;
import org.bson.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TripPrices
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|22:10
 * @Version TripPrices: 1.0
 */
public class TripPricesForm implements FormatClass{
    public String date;
    public String car_type;
    public String min_price;
    public String waiting_time;
    public String price_by_city;
    public String price_outside_the_city;

    public TripPricesForm() {
    }

    public TripPricesForm(String date, String car_type, String min_price, String waiting_time, String price_by_city, String price_outside_the_city) {
        this.date = date;
        this.car_type = car_type;
        this.min_price = min_price;
        this.waiting_time = waiting_time;
        this.price_by_city = price_by_city;
        this.price_outside_the_city = price_outside_the_city;
    }
    public TripPricesForm(TripPrices elem) {
        this.date = elem.date.toString();
        this.car_type = elem.car_type.toString();
        this.min_price = String.valueOf(elem.min_price);
        this.waiting_time = String.valueOf(elem.waiting_time);
        this.price_by_city = String.valueOf(elem.price_by_city);
        this.price_outside_the_city = String.valueOf(elem.price_outside_the_city);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(String waiting_time) {
        this.waiting_time = waiting_time;
    }

    public String getPrice_by_city() {
        return price_by_city;
    }

    public void setPrice_by_city(String price_by_city) {
        this.price_by_city = price_by_city;
    }

    public String getPrice_outside_the_city() {
        return price_outside_the_city;
    }

    public void setPrice_outside_the_city(String price_outside_the_city) {
        this.price_outside_the_city = price_outside_the_city;
    }
}
