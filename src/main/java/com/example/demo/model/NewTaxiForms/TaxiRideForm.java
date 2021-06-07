package com.example.demo.model.NewTaxiForms;

import com.example.demo.model.NewTaxi.DBDoced;
import com.example.demo.model.NewTaxi.NewTaxiElement;
import com.example.demo.model.NewTaxi.PaymentType;
import com.example.demo.model.NewTaxi.TaxiRide;
import org.bson.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiRide
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|21:54
 * @Version TaxiRide: 1.0
 */
public class TaxiRideForm implements FormatClass{
    public String ride_id;
    public String car_id;
    public String driver_id;
    public String start_date;
    public String finish_date;
    public String waiting_time;
    public String km_by_city;
    public String km_outside_the_city;
    public String payment_type;
    public String donation;

    public TaxiRideForm() {
    }

    public TaxiRideForm(String ride_id, String car_id, String driver_id, String start_date, String finish_date, String waiting_time, String km_by_city, String km_outside_the_city, String payment_type, String donation) {
        this.ride_id = ride_id;
        this.car_id = car_id;
        this.driver_id = driver_id;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.waiting_time = waiting_time;
        this.km_by_city = km_by_city;
        this.km_outside_the_city = km_outside_the_city;
        this.payment_type = payment_type;
        this.donation = donation;
    }
    public TaxiRideForm(TaxiRide elem) {
        this.ride_id = String.valueOf(elem.ride_id);
        this.car_id = String.valueOf(elem.car_id);
        this.driver_id = String.valueOf(elem.driver_id);
        this.start_date = elem.start_date.toString();
        this.finish_date = elem.finish_date.toString();
        this.waiting_time = String.valueOf(elem.waiting_time);
        this.km_by_city = String.valueOf(elem.km_by_city);
        this.km_outside_the_city = String.valueOf(elem.km_outside_the_city);
        this.payment_type = elem.payment_type.toString();
        this.donation = String.valueOf(elem.donation);
    }

    public String getRide_id() {
        return ride_id;
    }

    public void setRide_id(String ride_id) {
        this.ride_id = ride_id;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(String finish_date) {
        this.finish_date = finish_date;
    }

    public String getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(String waiting_time) {
        this.waiting_time = waiting_time;
    }

    public String getKm_by_city() {
        return km_by_city;
    }

    public void setKm_by_city(String km_by_city) {
        this.km_by_city = km_by_city;
    }

    public String getKm_outside_the_city() {
        return km_outside_the_city;
    }

    public void setKm_outside_the_city(String km_outside_the_city) {
        this.km_outside_the_city = km_outside_the_city;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }
}
