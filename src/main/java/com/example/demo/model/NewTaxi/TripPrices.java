package com.example.demo.model.NewTaxi;

import com.example.demo.model.NewTaxiForms.TaxiRideForm;
import com.example.demo.model.NewTaxiForms.TripPricesForm;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Price Entity")
public class TripPrices implements DBDoced, NewTaxiElement{
    public LocalDateTime date;
    public CarType car_type;
    public int min_price;
    public int waiting_time;
    public int price_by_city;
    public int price_outside_the_city;

    public TripPrices(CarType car_type, int min_price, int waiting_time, int price_by_city, int price_outside_the_city) {
        this.date = LocalDateTime.now();
        this.car_type = car_type;
        this.min_price = min_price;
        this.waiting_time = waiting_time;
        this.price_by_city = price_by_city;
        this.price_outside_the_city = price_outside_the_city;
    }
    private TripPrices(Document doc) {
        this.date = ((Date) doc.get("date")).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();;
        this.car_type = CarType.valueOf((String) doc.get("car_type"));
        this.min_price = (int) doc.get("min_price");
        this.waiting_time = (int) doc.get("waiting_time");
        this.price_by_city = (int) doc.get("price_by_city");
        this.price_outside_the_city = (int) doc.get("price_outside_the_city");
    }

    public TripPrices(TripPricesForm form)
    {
        this.date = LocalDateTime.parse(form.date);
        this.car_type = CarType.valueOf(form.car_type);
        this.min_price = Integer.parseInt(form.min_price);
        this.waiting_time = Integer.parseInt(form.waiting_time);
        this.price_by_city = Integer.parseInt(form.price_by_city);
        this.price_outside_the_city = Integer.parseInt(form.price_outside_the_city);
    }

    static public Object Create(Document doc){
        return new TripPrices(doc);
    }

    @Override
    public Document getDoc()
    {
        Document doc = new Document();
        doc.append("date",this.date);
        doc.append("car_type",this.car_type.toString());
        doc.append("min_price",this.min_price);
        doc.append("waiting_time",this.waiting_time);
        doc.append("price_by_city",this.price_by_city);
        doc.append("price_outside_the_city",this.price_outside_the_city);
        return doc;
    }

    @Override
    public Document setKey() {
        Document doc = new Document();
        doc.append("date",this.date);
        doc.append("car_type",this.car_type);
        return doc;
    }
    @Override
    public int compareTo(NewTaxiElement elem)
    {
        return this.car_type.compareTo(((TripPrices)elem).car_type) + this.date.compareTo(((TripPrices)elem).date);
    }

    @Override
    public NewTaxiElement clone()
    {
        TripPrices clone_price = new TripPrices(car_type, min_price, waiting_time, price_by_city, price_outside_the_city);
        clone_price.date = date;
        return clone_price;
    }

    @Override
    public String toHTML() {
        return "TripPrices{" +
                "<br>date=" + date +
                ", <br>car_type=" + car_type +
                ", <br>min_price=" + min_price +
                ", <br>waiting_time=" + waiting_time +
                ", <br>price_by_city=" + price_by_city +
                ", <br>price_outside_the_city=" + price_outside_the_city +
                "<br>}";
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public CarType getCar_type() {
        return car_type;
    }

    public void setCar_type(CarType car_type) {
        this.car_type = car_type;
    }

    public int getMin_price() {
        return min_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }

    public int getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }

    public int getPrice_by_city() {
        return price_by_city;
    }

    public void setPrice_by_city(int price_by_city) {
        this.price_by_city = price_by_city;
    }

    public int getPrice_outside_the_city() {
        return price_outside_the_city;
    }

    public void setPrice_outside_the_city(int price_outside_the_city) {
        this.price_outside_the_city = price_outside_the_city;
    }
}
