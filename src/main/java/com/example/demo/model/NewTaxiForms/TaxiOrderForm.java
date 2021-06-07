package com.example.demo.model.NewTaxiForms;

import com.example.demo.model.NewTaxi.*;
import org.bson.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiOrdering
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|20:46
 * @Version TaxiOrdering: 1.0
 */
public class TaxiOrderForm implements FormatClass{
    public String order_id;
    public String customer_id;
    public String ride_id;
    public String phone;
    public String start_address;
    public String finish_address;
    public String date_of_ordering;
    public String car_type;
    public String status;

    public TaxiOrderForm() {
    }

    public TaxiOrderForm(String order_id, String customer_id, String ride_id, String phone, String start_address, String finish_address, String date_of_ordering, String car_type, String status) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.ride_id = ride_id;
        this.phone = phone;
        this.start_address = start_address;
        this.finish_address = finish_address;
        this.date_of_ordering = date_of_ordering;
        this.car_type = car_type;
        this.status = status;
    }
    public TaxiOrderForm(TaxiOrder elem) {
        this.order_id = String.valueOf(elem.order_id);
        this.customer_id = String.valueOf(elem.customer_id);
        this.ride_id = String.valueOf(elem.ride_id);
        this.phone = elem.phone;
        this.start_address = elem.start_address;
        this.finish_address = elem.finish_address;
        this.date_of_ordering = elem.date_of_ordering.toString();
        this.car_type = elem.car_type.toString();
        this.status = elem.status.toString();
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getRide_id() {
        return ride_id;
    }

    public void setRide_id(String ride_id) {
        this.ride_id = ride_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStart_address() {
        return start_address;
    }

    public void setStart_address(String start_address) {
        this.start_address = start_address;
    }

    public String getFinish_address() {
        return finish_address;
    }

    public void setFinish_address(String finish_address) {
        this.finish_address = finish_address;
    }

    public String getDate_of_ordering() {
        return date_of_ordering;
    }

    public void setDate_of_ordering(String date_of_ordering) {
        this.date_of_ordering = date_of_ordering;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
